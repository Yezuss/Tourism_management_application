package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dao.DAO_NhanVien;
import dao.Tour_DAO;
import entity.HuongDanVien;
import entity.LoaiTour;
import entity.NhanVien;
import entity.TaiKhoan;
import entity.Tour;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;

public class QuanLyNhanVien extends JPanel implements ActionListener, MouseListener {
	private JTextField textField;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtDiachi;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtTuoi;
	private JTextField txtTim;
	private DefaultTableModel modelNhanVien;
	private JTable tableNV;
	private ArrayList<NhanVien> qlnhanvien;
	private JTextField txtMaTK;
	private JLabel lbltim;
	private JLabel lblGioitinh;
	private JButton btntim;
	private JButton btnthem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnLuu;
	private JButton btnXoarong;
	private JComboBox<String> cboGioiTinh;
	private DAO_NhanVien nv = new DAO_NhanVien();
	private DAO_NhanVien nv_dao;
	private JTextField txtPass;
	private JLabel lblMauTin;
	private int tongSoMauTin;
	private int mauTinHienHanh;
	private JButton btncuoi;

	private JButton btntiep;
	private JButton btndau;
	private JButton btnnguoc;

	/**
	 * Create the panel.
	 */
	public QuanLyNhanVien() {
		setBackground(SystemColor.textHighlightText);
		setBounds(0, 118, 1267, 540);
		setLayout(null);

		nv_dao = new DAO_NhanVien();

		JPanel panelnhaplieu = new JPanel();
		panelnhaplieu.setBounds(10, 11, 1330, 175);
		panelnhaplieu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(panelnhaplieu);
		panelnhaplieu.setLayout(null);

		JLabel lblManNV = new JLabel("Mã Nhân Viên :");
		lblManNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblManNV.setBounds(10, 11, 111, 23);
		panelnhaplieu.add(lblManNV);

		JLabel lblTenNV = new JLabel("Tên Nhân Viên :");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNV.setBounds(10, 61, 111, 23);
		panelnhaplieu.add(lblTenNV);

		JLabel lblPass = new JLabel("Mật khẩu:");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPass.setBounds(10, 100, 111, 23);
		panelnhaplieu.add(lblPass);

		JLabel lblSdt = new JLabel("S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i :");
		lblSdt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSdt.setBounds(409, 61, 93, 23);
		panelnhaplieu.add(lblSdt);

		JLabel lblDiachi = new JLabel("\u0110\u1ECBa Ch\u1EC9 :");
		lblDiachi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiachi.setBounds(409, 11, 66, 23);
		panelnhaplieu.add(lblDiachi);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(784, 11, 66, 23);
		panelnhaplieu.add(lblEmail);

		JLabel lblTuoi = new JLabel("Tu\u1ED5i :");
		lblTuoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTuoi.setBounds(784, 61, 66, 23);
		panelnhaplieu.add(lblTuoi);

		txtMaNV = new JTextField();
		txtMaNV.setBounds(122, 12, 226, 20);
		panelnhaplieu.add(txtMaNV);
		txtMaNV.setColumns(10);

		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(122, 62, 226, 20);
		panelnhaplieu.add(txtTenNV);

		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(122, 100, 226, 20);
		panelnhaplieu.add(txtPass);

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

		txtTuoi = new JTextField();
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
		lbltim.setBounds(10, 135, 102, 30);
		lbltim.setIcon(new ImageIcon("img/find2.png"));
		panelnhaplieu.add(lbltim);

		txtTim = new JTextField();
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTim.setColumns(10);
		txtTim.setBounds(122, 135, 362, 30);
		panelnhaplieu.add(txtTim);

		btntim = new JButton("Tìm Kiếm");
		btntim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btntim.setForeground(Color.WHITE);
		btntim.setFont(new Font("Tahoma", Font.BOLD, 12));
		btntim.setBackground(Color.BLUE);
		btntim.setBounds(494, 135, 110, 31);
		panelnhaplieu.add(btntim);

		JPanel paneldb = new JPanel();
		paneldb.setBounds(10, 201, 1330, 293);
		paneldb.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(paneldb);

		String[] colHeader = { "Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Email", "Tuổi", "Giới Tính",
				"Địa Chỉ", "Mật khẩu" };
		modelNhanVien = new DefaultTableModel(colHeader, 0);
		paneldb.setLayout(null);
		tableNV = new JTable(modelNhanVien);
		JScrollPane scrollPane = new JScrollPane(tableNV);
		scrollPane.setBounds(10, 11, 1150, 271);
		paneldb.add(scrollPane);
		tableNV.setRowHeight(25);
		for (NhanVien nv : nv_dao.getAllNV()) {
			Object[] rowData = { nv.getMaNV(), nv.getTenNV(), nv.getSdt(), nv.getEmail(), nv.getTuoi(),
					nv.isGioiTinh() ? "Nam" : "Nữ", nv.getDiaChi(), nv.getMatkhau() };
			modelNhanVien.addRow(rowData);
		}

		qlnhanvien = new ArrayList<NhanVien>();

		qlnhanvien = nv_dao.getAllNV();

		btnthem = new JButton("Thêm");
		btnthem.setBounds(1180, 11, 124, 37);
		btnthem.setIcon(new ImageIcon("img/them1.png"));
		paneldb.add(btnthem);

		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnSua.setBounds(1180, 59, 124, 37);
		btnSua.setIcon(new ImageIcon("img/sua.png"));
		paneldb.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(1180, 107, 124, 37);
		btnXoa.setIcon(new ImageIcon("img/remove.png"));
		paneldb.add(btnXoa);

		btnXoarong = new JButton("Xóa rỗng");
		btnXoarong.setBounds(1180, 155, 124, 37);
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

		btnthem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoarong.addActionListener(this);
		tableNV.addMouseListener(this);
		btndau.addActionListener(this);
		btntiep.addActionListener(this);
		btnnguoc.addActionListener(this);
		btncuoi.addActionListener(this);
		tableNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableNV.getSelectedRow();
				if (row >= 0) {
					mauTinHienHanh = row;
					capNhatThongTinMauTin(mauTinHienHanh);
				}
			}
		});

		mauTinHienHanh = -1;
		tongSoMauTin = tableNV.getRowCount();
		if (tongSoMauTin > 0) {
			mauTinHienHanh = 0;
			capNhatThongTinMauTin(mauTinHienHanh);
		}
	}

	private void capNhatThongTinMauTin(int n) {
		tableNV.setRowSelectionInterval(n, n);
		lblMauTin.setText(mauTinHienHanh + 1 + "/" + tongSoMauTin);
		napLopHocVaoTextfields();
	}

	private void napLopHocVaoTextfields() {
		// TODO Auto-generated method stub
		int row = tableNV.getSelectedRow();
		if (row >= 0) {
			NhanVien nv = qlnhanvien.get(row);
			txtMaNV.setText(modelNhanVien.getValueAt(row, 0).toString());
			txtTenNV.setText(modelNhanVien.getValueAt(row, 1).toString());
			txtSDT.setText(modelNhanVien.getValueAt(row, 2).toString());
			txtEmail.setText(modelNhanVien.getValueAt(row, 3).toString());
			txtTuoi.setText(modelNhanVien.getValueAt(row, 4).toString());
			cboGioiTinh.setSelectedItem(nv.isGioiTinh() ? "Nam" : "Nữ");
			txtDiachi.setText(modelNhanVien.getValueAt(row, 6).toString());
			txtPass.setText(modelNhanVien.getValueAt(row, 7).toString());

		}
	}

	public void xoaRong() {
		txtMaNV.setText("");
		txtMaNV.requestFocus();
		txtTenNV.setText("");
		txtSDT.setText("");
		txtEmail.setText("");
		txtTuoi.setText("");
		cboGioiTinh.setSelectedIndex(0);
		txtDiachi.setText("");
		txtPass.setText("");

	}

	public boolean validata() {
		if (txtMaNV.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống!");
			txtMaNV.requestFocus();
			return false;
		}

		if (txtSDT.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống!");

			return false;
		}

		if (txtEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống!");

			return false;
		}

		if (txtTuoi.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống!");

			return false;
		}

		if (txtDiachi.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống!");
			return false;
		}

		return true;
	}

	private void NapDLVaoList(ArrayList<NhanVien> dsNV) {
		DefaultTableModel n = (DefaultTableModel) tableNV.getModel();
		n.getDataVector().removeAllElements();
		for (NhanVien nv : nv_dao.getAllNV()) {
			Object[] rowData = { nv.getMaNV(), nv.getTenNV(), nv.getSdt(), nv.getEmail(), nv.getTuoi(),
					nv.isGioiTinh() ? "Nam" : "Nữ", nv.getDiaChi(), nv.getMatkhau() };
			modelNhanVien.addRow(rowData);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableNV.getSelectedRow();
		NhanVien nv = qlnhanvien.get(row);
		txtMaNV.setText(modelNhanVien.getValueAt(row, 0).toString());
		txtTenNV.setText(modelNhanVien.getValueAt(row, 1).toString());
		txtSDT.setText(modelNhanVien.getValueAt(row, 2).toString());
		txtEmail.setText(modelNhanVien.getValueAt(row, 3).toString());
		txtTuoi.setText(modelNhanVien.getValueAt(row, 4).toString());
		cboGioiTinh.setSelectedItem(nv.isGioiTinh() ? "Nam" : "Nữ");
		txtDiachi.setText(modelNhanVien.getValueAt(row, 6).toString());
		txtPass.setText(modelNhanVien.getValueAt(row, 7).toString());

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

	private void xoaNV() {
		if (tableNV.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Hãy chọn khách hàng cần xóa");
		} else {
			int tl;
			tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khách hàng này không ?", "Cảnh báo",
					JOptionPane.YES_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				int index = tableNV.getSelectedRow();
				nv_dao.XoaNV(modelNhanVien.getValueAt(tableNV.getSelectedRow(), 0).toString());
				modelNhanVien.removeRow(index);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnthem)) {
			if (validata()) {
				String ma = txtMaNV.getText();
				String ten = txtTenNV.getText();
				String sdt = txtSDT.getText();
				String email = txtEmail.getText();
				String tuoi = txtTuoi.getText();
				boolean gt = cboGioiTinh.getSelectedIndex() == 0;
				String dc = txtDiachi.getText();
				String mk = txtPass.getText();

				NhanVien nv = new NhanVien(ma, ten, sdt, email, tuoi, gt, dc, mk);

				if (nv_dao.createNV(nv)) {
					modelNhanVien.addRow(new Object[] { nv.getMaNV(), nv.getTenNV(), nv.getSdt(), nv.getEmail(),
							nv.getTuoi(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getDiaChi(), nv.getMatkhau() });
				}

				else {
					JOptionPane.showMessageDialog(this, "Lỗi trùng mã khách hàng");
				}

			}
		}

		else if (o.equals(btnXoarong)) {

			xoaRong();
		} else if (tongSoMauTin > 0) { // Cho cÃ¡c nÃºt duyá»‡t
			if (o.equals(btndau))
				mauTinHienHanh = 0;
			else if (o.equals(btncuoi))
				mauTinHienHanh = tongSoMauTin - 1;
			else if (o.equals(btnnguoc) && mauTinHienHanh < tongSoMauTin - 1)
				mauTinHienHanh++;
			else if (o.equals(btntiep) && mauTinHienHanh > 0)
				mauTinHienHanh--;
			capNhatThongTinMauTin(mauTinHienHanh);
		} else if (o.equals(btnXoa)) {
			xoaNV();
		}

	}

}
