package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.KeySelectorResult;

import dao.DAO_KhachHang;

import dao.Tour_DAO;
import entity.KhachHang;
import entity.NhanVien;
import entity.Regex;
import entity.Tour;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import java.awt.Color;

public class QuanLyKhachHang extends JPanel implements ActionListener, MouseListener,KeyListener {
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtDiachi;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtTuoi;
	private DefaultTableModel modelKhachHang;
	private JTable tableKH;
	private JTextField txtTim;

	private DAO_KhachHang qlKhachHang;
	private Regex regex;
	private String column[] = { "Mã KH", "Tên Khách Hàng", "Số điện thoại ", "Tuổi", "Email", "Giới tính", "Địa Chỉ" };

	private DAO_KhachHang kh_dao;
	private Object maKH;
	private int tongSoMauTin;
	private int mauTinHienHanh;

	private JButton btnSua;
	private JButton btnLuu;
	private JButton btnXoarong;
	private JButton btndau;
	private JButton btntiep;
	private JButton btnnguoc;
	private JButton btncuoi;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btntim;
	private JLabel lbltim;

	private JLabel lblGioitinh;
	private JComboBox<String> cboGioiTinh;
	private ArrayList<KhachHang> qlKH;
	private JLabel lblMauTin;

	/**
	 * Create the panel.
	 */
	public QuanLyKhachHang() {
		setBackground(SystemColor.textHighlightText);
		setBounds(0, 118, 1267, 540);
		setLayout(null);
		
		kh_dao = new DAO_KhachHang();

		JPanel panelnhaplieu = new JPanel();
		panelnhaplieu.setBounds(10, 11, 1234, 175);
		panelnhaplieu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(panelnhaplieu);
		panelnhaplieu.setLayout(null);

		JLabel lblMaKH = new JLabel("Mã khách hàng :");
		lblMaKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaKH.setBounds(10, 11, 111, 23);
		panelnhaplieu.add(lblMaKH);

		JLabel lblTenKH = new JLabel("Tên khách hàng :");
		lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenKH.setBounds(10, 61, 111, 23);
		panelnhaplieu.add(lblTenKH);

		JLabel lblSdt = new JLabel("Số điện thoại :");
		lblSdt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSdt.setBounds(409, 61, 93, 23);
		panelnhaplieu.add(lblSdt);

		JLabel lblDiachi = new JLabel("Địa chỉ :");
		lblDiachi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiachi.setBounds(409, 11, 66, 23);
		panelnhaplieu.add(lblDiachi);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(784, 11, 66, 23);
		panelnhaplieu.add(lblEmail);

		JLabel lblTuoi = new JLabel("Tuổi :");
		lblTuoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTuoi.setBounds(784, 61, 66, 23);
		panelnhaplieu.add(lblTuoi);

		txtMaKH = new JTextField();
		txtMaKH.setBounds(122, 12, 226, 20);
		panelnhaplieu.add(txtMaKH);
		txtMaKH.setColumns(10);

		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(122, 62, 226, 20);
		panelnhaplieu.add(txtTenKH);

		txtDiachi = new JTextField();
		txtDiachi.setColumns(10);
		txtDiachi.setBounds(507, 12, 226, 20);
		panelnhaplieu.add(txtDiachi);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(507, 62, 226, 20);
		panelnhaplieu.add(txtSDT);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(892, 12, 226, 20);
		panelnhaplieu.add(txtEmail);

		txtTuoi = new JTextField("18");
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(892, 62, 226, 20);
		panelnhaplieu.add(txtTuoi);

		lblGioitinh = new JLabel("Giới Tính :");
		lblGioitinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGioitinh.setBounds(784, 120, 66, 23);
		panelnhaplieu.add(lblGioitinh);

		cboGioiTinh = new JComboBox<String>();
		cboGioiTinh.setBounds(892, 120, 80, 20);
		cboGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cboGioiTinh.addItem("Nam");
		cboGioiTinh.addItem("Nữ");
		cboGioiTinh.setEditable(false);
		panelnhaplieu.add(cboGioiTinh);
		

		lbltim = new JLabel("Tìm kiếm");
		lbltim.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbltim.setBounds(10, 113, 102, 30);
		lbltim.setIcon(new ImageIcon("img/find2.png"));
		panelnhaplieu.add(lbltim);

		txtTim = new JTextField();
		txtTim.setToolTipText("Nhập mã hoặc tên khách hàng cần tìm");
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTim.setColumns(10);
		txtTim.setBounds(122, 116, 362, 30);
		panelnhaplieu.add(txtTim);

		btntim = new JButton("Tìm Kiếm");
		btntim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btntim.setForeground(Color.WHITE);
		btntim.setFont(new Font("Tahoma", Font.BOLD, 12));
		btntim.setBackground(Color.BLUE);
		btntim.setBounds(494, 116, 110, 31);
		panelnhaplieu.add(btntim);

		JPanel paneldb = new JPanel();
		paneldb.setBounds(10, 201, 1234, 293);
		paneldb.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(paneldb);

		modelKhachHang = new DefaultTableModel(column, 0);
		paneldb.setLayout(null);
		tableKH = new JTable(modelKhachHang);
		JScrollPane scrollPane = new JScrollPane(tableKH);
		scrollPane.setBounds(10, 11, 1063, 271);
		paneldb.add(scrollPane);

		btnThem = new JButton("Thêm");
		(btnThem).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == btnThem)
					themKH();
			}
		});
		btnThem.setBounds(1083, 11, 124, 37);
		btnThem.setIcon(new ImageIcon("img/them1.png"));
		paneldb.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}

		});
		btnSua.setBounds(1083, 59, 124, 37);
		btnSua.setIcon(new ImageIcon("img/sua.png"));
		paneldb.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object key = e.getSource();
				if (key == btnXoa)
					xoaKH();
			}

		});
		btnXoa.setBounds(1083, 107, 124, 37);
		btnXoa.setIcon(new ImageIcon("img/remove.png"));
		paneldb.add(btnXoa);


		btnXoarong = new JButton("Xóa rỗng");
		btnXoarong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTenKH.setText("");
				;
				txtSDT.setText("");
				txtEmail.setText("");
				txtTuoi.setText("");
				txtDiachi.setText("");
				txtMaKH.setText("");

			}

		});
		btnXoarong.setBounds(1083, 155, 124, 37);
		btnXoarong.setIcon(new ImageIcon("img/xoarong.png"));
		paneldb.add(btnXoarong);

		btndau = new JButton(new ImageIcon("img/go-first.png"));
		btndau.setBounds(401, 505, 89, 23);
		add(btndau);
		add(lblMauTin = new JLabel());
		btntiep = new JButton(new ImageIcon("img/go-previous.png"));
		btntiep.setBounds(500, 505, 89, 23);
		add(btntiep);

		btnnguoc = new JButton(new ImageIcon("img/go-next.png"));
		btnnguoc.setBounds(599, 505, 89, 23);
		add(btnnguoc);

		btncuoi = new JButton(new ImageIcon("img/go-last.png"));
		btncuoi.setBounds(698, 505, 89, 23);
		add(btncuoi);
		
		qlKH = new ArrayList<KhachHang>();

		qlKH = kh_dao.getAllKhachHang();

		regex = new Regex();
		DocDuLieuDatabase();
		btndau.addActionListener(this);
		btntiep.addActionListener(this);
		btnnguoc.addActionListener(this);
		btncuoi.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoarong.addActionListener(this);
		btnXoa.addActionListener(this);
		btntim.addActionListener(this);
		tableKH.addMouseListener(this);
		btnThem.setMnemonic(KeyEvent.VK_T);
		btnXoa.setMnemonic(KeyEvent.VK_X);
		btnSua.setMnemonic(KeyEvent.VK_S);
		btnXoarong.setMnemonic(KeyEvent.VK_R);
		btntim.setMnemonic(KeyEvent.VK_K);
		tableKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableKH.getSelectedRow();
				if (row >= 0) {
					mauTinHienHanh = row;
					capNhatThongTinMauTin(mauTinHienHanh);
				}
			}
		});

		mauTinHienHanh = -1;
		tongSoMauTin = tableKH.getRowCount();
		if (tongSoMauTin > 0) {
			mauTinHienHanh = 0;
			capNhatThongTinMauTin(mauTinHienHanh);
		}
	}


	private void capNhatThongTinMauTin(int n) {
		tableKH.setRowSelectionInterval(n, n);
		lblMauTin.setText(mauTinHienHanh + 1 + "/" + tongSoMauTin);
		napLopHocVaoTextfields();
	}

	private void napLopHocVaoTextfields() {
		// TODO Auto-generated method stub
		int row = tableKH.getSelectedRow();
		if (row >= 0) {
			KhachHang kh = qlKH.get(row);//
			txtMaKH.setText(modelKhachHang.getValueAt(row, 0).toString());
			txtTenKH.setText(modelKhachHang.getValueAt(row, 1).toString());
			txtSDT.setText(modelKhachHang.getValueAt(row, 2).toString());
			txtTuoi.setText(modelKhachHang.getValueAt(row, 3).toString());
			txtEmail.setText(modelKhachHang.getValueAt(row, 4).toString());
			cboGioiTinh.setSelectedItem(kh.isGioiTinh() ? "Nam" : "Nữ");
			txtDiachi.setText(modelKhachHang.getValueAt(row, 6).toString());
		}
		}
	

	private void DocDuLieuDatabase() {
		// TODO Auto-generated method stub
		kh_dao = new DAO_KhachHang();
		tableKH.setRowHeight(25);
		for (KhachHang kh : kh_dao.getAllKhachHang()) {
			modelKhachHang.addRow(new Object[] { kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getEmail(), kh.getTuoi(),
					kh.isGioiTinh()? "Nam" : "Nữ", kh.getDiaChi() });
		}

	}

	public String strGioiTinh(Boolean nv) {
		if (nv) {
			return "Nam";
		}
		return "Nữ";
	}

	private boolean kiemTra() {
		if (regex.kiemTraRong(txtMaKH))
			return false;
		if (regex.RegexMa(txtMaKH))
			return false;
		if (regex.kiemTraRong(txtTenKH))
			return false;
		if (regex.RegexTen(txtTenKH))
			return false;
		if (regex.kiemTraRong(txtSDT))
			return false;
		if (regex.RegexSDT(txtSDT))
			return false;
		if (regex.kiemTraRong(txtDiachi))
			return false;
		if (regex.RegexDiaChi(txtDiachi))
			return false;
		if (regex.kiemTraTuoi(txtTuoi))
			return false;
		if (regex.RegexGmail(txtEmail))
			return false;
		if (regex.kiemTraRong(txtEmail))
			return false;
		return true;
	}

	private void clearTable() {
		while (tableKH.getRowCount() > 0) {
			modelKhachHang.removeRow(0);
		}
	}

	private void suaKH() {
		// TODO Auto-generated method stub
		if (tableKH.getSelectedRow() == -1) {
			if (kiemTra()) {
				String maKH = txtMaKH.getText();
				String tenKH = txtTenKH.getText();
				String sdt = txtSDT.getText();
				String tuoi = txtTuoi.getText();
				String email = txtEmail.getText();
				String diachi = txtDiachi.getText();
				boolean gioitinh = true;
				KhachHang kh = new KhachHang(maKH, tenKH, sdt, email, tuoi, gioitinh, diachi);
				if (kh_dao.update(kh)) {
					clearTable();
					ArrayList<KhachHang> ds = kh_dao.getAllKhachHang();
					DocDuLieuDatabase();
				} else {
					JOptionPane.showMessageDialog(this, "Sửa thất bại");
				}
			}
		}
	}
	/*
	 * private void xoaKH() throws SQLException {
	 * 
	 * if (tableKH.getSelectedRow() == -1) { JOptionPane.showMessageDialog(this,
	 * "Hãy chọn khách hàng cần xóa"); } else { int tl; tl =
	 * JOptionPane.showConfirmDialog(this,
	 * "Bạn có chắc chắn muốn xóa khách hàng này không ?", "Cảnh báo",
	 * JOptionPane.YES_OPTION); if (tl == JOptionPane.YES_OPTION) { int index =
	 * tableKH.getSelectedRow();
	 * kh_dao.xoaKH(modelKhachHang.getValueAt(tableKH.getSelectedRow(),
	 * 0).toString()); modelKhachHang.removeRow(index); } }
	 * 
	 * }
	 */

	private void xoaKH() {
		if (tableKH.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Hãy chọn khách hàng cần xóa");
		} else {
			int tl;
			tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khách hàng này không ?", "Cảnh báo",
					JOptionPane.YES_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				int index = tableKH.getSelectedRow();
				kh_dao.xoaKH(modelKhachHang.getValueAt(tableKH.getSelectedRow(), 0).toString());
				modelKhachHang.removeRow(index);
			}
		}

	}

	private void themKH() {
		// TODO Auto-generated method stub
		if (kiemTra()) {

			String maKH = txtMaKH.getText();
			String tenKH = txtTenKH.getText();
			String sdt = txtSDT.getText();
			String tuoi = txtTuoi.getText();
			String email = txtEmail.getText();
			String diachi = txtDiachi.getText();
			boolean gioitinh = true;
			KhachHang kh = new KhachHang(maKH, tenKH, sdt, email, tuoi, gioitinh, diachi);

			if (kh_dao.createKH(kh)) {
				modelKhachHang.addRow(new Object[] { kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getEmail(),
						kh.getTuoi(), strGioiTinh(kh.isGioiTinh()), kh.getDiaChi() });
			}

			 else {
				JOptionPane.showMessageDialog(this, "Lỗi trùng mã khách hàng");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableKH.getSelectedRow();
		KhachHang kh = qlKH.get(row);//
		txtMaKH.setText(modelKhachHang.getValueAt(row, 0).toString());
		txtTenKH.setText(modelKhachHang.getValueAt(row, 1).toString());
		txtSDT.setText(modelKhachHang.getValueAt(row, 2).toString());
		txtTuoi.setText(modelKhachHang.getValueAt(row, 3).toString());
		txtEmail.setText(modelKhachHang.getValueAt(row, 4).toString());
		cboGioiTinh.setSelectedItem(kh.isGioiTinh() ? "Nam" : "Nữ");
		txtDiachi.setText(modelKhachHang.getValueAt(row, 6).toString());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnSua)) {
			suaKH();
		}else if (tongSoMauTin > 0) { // Cho cÃ¡c nÃºt duyá»‡t
			if (o.equals(btndau))
				mauTinHienHanh = 0;
			else if (o.equals(btncuoi))
				mauTinHienHanh = tongSoMauTin - 1;
			else if (o.equals(btnnguoc) && mauTinHienHanh < tongSoMauTin - 1)
				mauTinHienHanh++;
			else if (o.equals(btntiep) && mauTinHienHanh > 0)
				mauTinHienHanh--;
			capNhatThongTinMauTin(mauTinHienHanh);
		
		}
		else if(o.equals(btntim)){
			DAO_KhachHang kh = new DAO_KhachHang();
			List<KhachHang> list = kh.getKhachHangthemaKH(txtMaKH.getText());
			
			if (txtMaKH.getText().equals("")) 
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khách hàng cần tìm!");
			else if(list.size()==0) 
				   JOptionPane.showMessageDialog(this, "Không tìm thấy!!!");
			else 
			 {	
				modelKhachHang.getDataVector().removeAllElements();;
				DocDuLieuDatabase();
		
			 }}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	private void xoaHetModel() {
		DefaultTableModel df = (DefaultTableModel) tableKH.getModel();
		df.getDataVector().removeAllElements();
		tableKH.clearSelection();
	}
	@Override
	public void keyReleased(KeyEvent e) {
	/*?Dao.getMaLaoDong() != null) {

				txtTenLD.setText(ld.getTenLaoDong());
				txtCMND.setText(ld.getCMND());
				txtSdt.setText(ld.getSDT());
				ngaySinh.setDate(ld.getNgaySinh());
				cboTrinhDo.setSelectedItem(ld.getTrinhDo().getTenTrinhDo());
				cboTinhTP.setSelectedItem(ld.getDiaChi().getTinhTP());
				cboQuanHuyen.setSelectedItem(ld.getDiaChi().getQuanHuyen());
				cboPhuongXa.setSelectedItem(ld.getDiaChi().getPhuongXa());
				cboGioiTinh.setSelectedItem(ld.isGioiTinh() ? "Nam" : "Ná»¯");

				int kt = JOptionPane.showConfirmDialog(null, "Lao Ä‘á»™ng Ä‘Ã£ tá»«ng lÃ m viá»‡c báº¡n cÃ³ muá»‘n thÃªm láº¡i",
						"ThÃ´ng bÃ¡o", JOptionPane.YES_NO_OPTION);
				if (kt == JOptionPane.YES_OPTION) {
					lDao.capNhatTrangThai(ld, true);
					JOptionPane.showMessageDialog(null, "ThÃªm thÃ nh cÃ´ng");
				}
				xoaRong();
				xoaHetModel();
				docDuLieu();

			}
		} else {
			xoaHetModel();
			docDuLieu();
		}*/

	}
}
