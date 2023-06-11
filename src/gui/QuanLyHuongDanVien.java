package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.DAO_NhanVien;
import dao.DAO_HuongDanVien;
import dao.DAO_KhachHang;
import entity.HuongDanVien;
import entity.KhachHang;
import entity.NhanVien;
import entity.Regex;
import entity.Tour;

public class QuanLyHuongDanVien extends JPanel implements ActionListener, MouseListener {

	private JTextField txtMaHDV;
	private JTextField txtTenHDV;
	private JTextField txtDiachi;
	private JTextField txtSDT;
	private JTextField txtTuoi;
	private JTextField txtTim;
	private DefaultTableModel modelHDVien;
	private JTable tableHDV;
	private ArrayList<HuongDanVien> qlHDV;
	private DAO_HuongDanVien hdv_dao;
	private JDateChooser ngaysinh;
	private JLabel lblGioitinh;
	private JComboBox<String> cboGioiTinh;
	private JButton btnthem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXoarong;
	private JButton btncuoi;
	private JButton btnnguoc;
	private JButton btntiep;
	private JButton btndau;
	private JLabel lblMauTin;
	private int tongSoMauTin;
	private int mauTinHienHanh;
	private Regex regex;
	/**
	 * Create the panel.
	 */
	public QuanLyHuongDanVien() {

		regex = new Regex();
		setBackground(SystemColor.textHighlightText);
		setBounds(0, 118, 1267, 540);
		setLayout(null);
		
		hdv_dao = new DAO_HuongDanVien();
		
		JPanel panelnhaplieu = new JPanel();
		panelnhaplieu.setBounds(10, 11, 1234, 175);
		panelnhaplieu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(panelnhaplieu);
		panelnhaplieu.setLayout(null);
		
		JLabel lblMaHDV = new JLabel("M\u00E3 HD Vi\u00EAn :");
		lblMaHDV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaHDV.setBounds(10, 11, 111, 23);
		panelnhaplieu.add(lblMaHDV);
		
		JLabel lblTenHDV = new JLabel("T\u00EAn D\u1EABn Vi\u00EAn :");
		lblTenHDV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenHDV.setBounds(10, 61, 111, 23);
		panelnhaplieu.add(lblTenHDV);
		
		JLabel lblSdt = new JLabel("S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i :");
		lblSdt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSdt.setBounds(409, 61, 93, 23);
		panelnhaplieu.add(lblSdt);
		
		JLabel lblDiachi = new JLabel("\u0110\u1ECBa Ch\u1EC9 :");
		lblDiachi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiachi.setBounds(409, 11, 93, 23);
		panelnhaplieu.add(lblDiachi);
		
		JLabel lblngaysinh = new JLabel("Ngày sinh :");
		lblngaysinh.setBounds(784, 12, 80, 28);
		lblngaysinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		ngaysinh = new JDateChooser();
		ngaysinh.setBounds(892, 11, 226, 20);
		ngaysinh.setDateFormatString("dd/MM/yyyy");
		panelnhaplieu.add(ngaysinh);
		panelnhaplieu.add(lblngaysinh);
		
		txtMaHDV = new JTextField();
		txtMaHDV.setBounds(122, 12, 226, 20);
		panelnhaplieu.add(txtMaHDV);
		txtMaHDV.setColumns(10);
		
		txtTenHDV = new JTextField();
		txtTenHDV.setColumns(10);
		txtTenHDV.setBounds(122, 62, 226, 20);
		panelnhaplieu.add(txtTenHDV);
		
		txtDiachi = new JTextField();
		txtDiachi.setColumns(10);
		txtDiachi.setBounds(507, 12, 226, 20);
		panelnhaplieu.add(txtDiachi);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(507, 62, 226, 20);
		panelnhaplieu.add(txtSDT);
	
		
		lblGioitinh = new JLabel("Giới Tính :");
		lblGioitinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGioitinh.setBounds(784, 62, 75, 23);
		panelnhaplieu.add(lblGioitinh);

		cboGioiTinh = new JComboBox<String>();
		cboGioiTinh.setBounds(892, 62, 80, 20);
		cboGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cboGioiTinh.addItem("Nam");
		cboGioiTinh.addItem("Nữ");
		cboGioiTinh.setEditable(false);
		panelnhaplieu.add(cboGioiTinh);
		
		
		
		JLabel lbltim = new JLabel("Tìm kiếm");
		lbltim.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbltim.setBounds(10, 113, 102, 30);
		lbltim.setIcon(new ImageIcon("img/find2.png"));
		panelnhaplieu.add(lbltim);
		
		txtTim = new JTextField();
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTim.setColumns(10);
		txtTim.setBounds(122, 116, 362, 30);
		panelnhaplieu.add(txtTim);
		
		JButton btntim = new JButton("Tìm Kiếm");
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
		
		String[] colHeader = { "Mã hướng dẫn viên", "Tên hướng dẫn viên", "Ngày sinh", "Giới Tính", "Địa Chỉ","Số điện thoại"};
		modelHDVien = new DefaultTableModel(colHeader, 0);
		paneldb.setLayout(null);
		tableHDV = new JTable(modelHDVien);
		JScrollPane scrollPane = new JScrollPane(tableHDV);
		scrollPane.setBounds(10, 11, 1063, 271);
		tableHDV.setRowHeight(25);
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for (HuongDanVien hdv : hdv_dao.getallHuongDanVien()) {
			Object[] rowData = { hdv.getMaHDV(), hdv.getHoten(), df.format(hdv.getNgaysinh()), hdv.isGioiTinh() ? "Nam" : "Nữ", 
					hdv.getDiaChi(), hdv.getSdt()};
			modelHDVien.addRow(rowData);
		}
		paneldb.add(scrollPane);
		
		qlHDV = new ArrayList<HuongDanVien>();

		qlHDV = hdv_dao.getallHuongDanVien();
		/*
		 * qlHDV = new DAO_HuongDanVien(); tableHDV.setRowHeight(25); for (HuongDanVien
		 * nv : qlHDV.getallHuongDanVien()) { Object[] rowData = {
		 * nv.getMaHDV(),nv.getHoten(),nv.getDiaChi(),nv.getNgaysinh(),nv.
		 * getSdt(),nv.isGioiTinh()}; modelHDVien.addRow(rowData); }
		 */
		 
		
		btnthem = new JButton("Thêm");
		btnthem.setBounds(1083, 11, 124, 37);
		btnthem.setIcon(new ImageIcon("img/them1.png"));
		paneldb.add(btnthem);
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(1083, 59, 124, 37);
		btnSua.setIcon(new ImageIcon("img/sua.png"));
		paneldb.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(1083, 107, 124, 37);
		btnXoa.setIcon(new ImageIcon("img/remove.png"));
		paneldb.add(btnXoa);
		
		btnXoarong = new JButton("Xóa rỗng");
		btnXoarong.setBounds(1083, 155, 124, 37);
		btnXoarong.setIcon(new ImageIcon("img/xoarong.png"));
		paneldb.add(btnXoarong);
		
		btndau = new JButton(new ImageIcon("img/go-first.png"));
		btndau.setBounds(401, 505, 89, 23);
		add(btndau);
		
		btntiep = new JButton(new ImageIcon("img/go-previous.png"));
		btntiep.setBounds(500, 505, 89, 23);
		add(btntiep);
		add(lblMauTin = new JLabel());
		btnnguoc = new JButton(new ImageIcon("img/go-next.png"));
		btnnguoc.setBounds(599, 505, 89, 23);
		add(btnnguoc);
		
		btncuoi = new JButton(new ImageIcon("img/go-last.png"));
		btncuoi.setBounds(698, 505, 89, 23);
		add(btncuoi);
		btndau.addActionListener(this);
		btntiep.addActionListener(this);
		btnnguoc.addActionListener(this);
		btncuoi.addActionListener(this);
		tableHDV.addMouseListener(this);
		btnthem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoarong.addActionListener(this);
		tableHDV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableHDV.getSelectedRow();
				if (row >= 0) {
					mauTinHienHanh = row;
					capNhatThongTinMauTin(mauTinHienHanh);
				}
			}
		});

		mauTinHienHanh = -1;
		tongSoMauTin = tableHDV.getRowCount();
		if (tongSoMauTin > 0) {
			mauTinHienHanh = 0;
			capNhatThongTinMauTin(mauTinHienHanh);
		}

	}
	private void capNhatThongTinMauTin(int n) {
		tableHDV.setRowSelectionInterval(n, n);
		lblMauTin.setText(mauTinHienHanh + 1 + "/" + tongSoMauTin);
		napLopHocVaoTextfields();
	}

	private void napLopHocVaoTextfields() {
		// TODO Auto-generated method stub
		int row = tableHDV.getSelectedRow();
		if (row >= 0) {
			HuongDanVien hdv = qlHDV.get(row);
			txtMaHDV.setText(modelHDVien.getValueAt(row, 0).toString());
			txtTenHDV.setText(modelHDVien.getValueAt(row, 1).toString());
			String ns[] = modelHDVien.getValueAt(row, 2).toString().split("/");
			ngaysinh.setDate(new Date(Integer.parseInt(ns[2]) - 1900, Integer.parseInt(ns[1]) - 1,
					Integer.parseInt(ns[0])));
			cboGioiTinh.setSelectedItem(hdv.isGioiTinh() ? "Nam" : "Nữ");
			txtDiachi.setText(modelHDVien.getValueAt(row, 4).toString());
			txtSDT.setText(modelHDVien.getValueAt(row, 5).toString());
		}
		}
	

	public void xoaRong() {
		txtMaHDV.setText("");
		txtMaHDV.requestFocus();
		txtTenHDV.setText("");
		txtSDT.setText("");
		cboGioiTinh.setSelectedIndex(0);
		txtDiachi.setText("");
		ngaysinh.setDate(null);

		
	}
	private boolean kiemTra() {
		if (regex.kiemTraRong(txtMaHDV))
			return false;
		if (regex.RegexMaHDV(txtMaHDV))
			return false;
		if (regex.kiemTraRong(txtTenHDV))
			return false;
		if (regex.RegexTen(txtTenHDV))
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
	
		return true;
	}

	public boolean validata() {
		
		
		
		if (txtSDT.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống!");
			
			return false;
		}
		
		
		return true;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableHDV.getSelectedRow();
		HuongDanVien hdv = qlHDV.get(row);
		txtMaHDV.setText(modelHDVien.getValueAt(row, 0).toString());
		txtTenHDV.setText(modelHDVien.getValueAt(row, 1).toString());
		String ns[] = modelHDVien.getValueAt(row, 2).toString().split("/");
		ngaysinh.setDate(new Date(Integer.parseInt(ns[2]) - 1900, Integer.parseInt(ns[1]) - 1,
				Integer.parseInt(ns[0])));
		cboGioiTinh.setSelectedItem(hdv.isGioiTinh() ? "Nam" : "Nữ");
		txtDiachi.setText(modelHDVien.getValueAt(row, 4).toString());
		txtSDT.setText(modelHDVien.getValueAt(row, 5).toString());
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		Object o = e.getSource();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		if (o.equals(btnthem)) {
			if (kiemTra()) {
				String ma = txtMaHDV.getText();
				String ten = txtTenHDV.getText();
				Date ns = ngaysinh.getDate();
				String n[] = df.format(ns).split("/");
				java.sql.Date kh = new java.sql.Date(Integer.parseInt(n[2]) - 1900, Integer.parseInt(n[1]) - 1,
						Integer.parseInt(n[0]));
				boolean gt = cboGioiTinh.getSelectedIndex() == 0;
				String dc = txtDiachi.getText();
				String sdt = txtSDT.getText();

				
				HuongDanVien hdv = new HuongDanVien(ma, ten, ns, gt, dc, sdt);
				
				
				if(hdv_dao.themCT(hdv)) {
				modelHDVien.addRow(new Object[] {hdv.getMaHDV(), hdv.getHoten(), df.format(hdv.getNgaysinh()), hdv.isGioiTinh() ? "Nam" : "Nữ", 
						hdv.getDiaChi(), hdv.getSdt()});}
				else {
					JOptionPane.showMessageDialog(this, "Lỗi trùng mã");
				}
			}
		}
		else if (tongSoMauTin > 0) { // Cho cÃ¡c nÃºt duyá»‡t
			if (o.equals(btndau))
				mauTinHienHanh = 0;
			else if (o.equals(btncuoi))
				mauTinHienHanh = tongSoMauTin - 1;
			else if (o.equals(btnnguoc) && mauTinHienHanh < tongSoMauTin - 1)
				mauTinHienHanh++;
			else if (o.equals(btntiep) && mauTinHienHanh > 0)
				mauTinHienHanh--;
			capNhatThongTinMauTin(mauTinHienHanh);}
		 if (o.equals(btnXoarong)) {
				
				xoaRong();
			}
		
		if (o.equals(btnXoa)) {
			if (tableHDV.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Hãy chọn hướng dẫn viên cần xóa");
			} else {
				int tl;
				tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa hướng dẫn viên này không ?", "Cảnh báo",
						JOptionPane.YES_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					while (tableHDV.getSelectedRowCount() > 0) {
						int index = tableHDV.getSelectedRow();
						try {
							hdv_dao.xoaHDV(modelHDVien.getValueAt(tableHDV.getSelectedRow(), 0).toString());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						modelHDVien.removeRow(index);
					}
				}else
					JOptionPane.showMessageDialog(this, "Không thành công");
			}
			
		}
		
	
	}

}
