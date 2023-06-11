package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_HuongDanVien;
import dao.Tour_DAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import entity.*;

public class QuanLyTour extends JPanel implements ActionListener, MouseListener, KeyListener {

	private DefaultTableModel modelTour;
	private JTable tableTour;
	private JTextField txttimMa;
	private JButton btnDau;
	private JButton btnTruoc;
	private JLabel lblMauTin;
	private JButton btnSau;
	private JButton btnCuoi;
	public static QuanLyTour qlTour;
	private Tour_DAO tour_dao;
	private XemDSKH form;
	private DatVe formdatve;
	private JTextField txtMaTour;
	private JTextField txtTenTour;
	private JTextField txtsoluongkhach;
	private JTextField txtdonvitochuc;
	private JTextField txttrangthai;
	private JTextField txtlichTrinh;
	private JTextField txtgiaTour;
	private JTextField txtphuongtien;
	private JTextField txtmaHDV;
	private JTextField txtmaLoaiTour;
	private JDateChooser ngayKH;
	private JDateChooser ngayKT;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private Tour_DAO tour = new Tour_DAO();
	private ArrayList<Tour> listTour;
	private JButton btntim;
	private JTextField txttimTen;
	private Regex regex;
	private JButton btndau;
	private JButton btntiep;
	private JButton btnnguoc;
	private JButton btncuoi;
	private JButton btndatve;
	private JButton btnxemds;
	private int tongSoMauTin;
	private int mauTinHienHanh;

	/**
	 * Create the panel.
	 */
	public QuanLyTour() {

		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		qlTour = this;

		tour_dao = new Tour_DAO();

		setBackground(SystemColor.textHighlightText);
		setBounds(0, 118, 1500, 540);
		setLayout(null);

		JPanel panelnhaplieu = new JPanel();
		panelnhaplieu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelnhaplieu.setBounds(0, 0, 261, 529);
		add(panelnhaplieu);
		panelnhaplieu.setLayout(null);

		JLabel lblmatour = new JLabel("Mã tour :");
		lblmatour.setBounds(10, 11, 80, 28);
		lblmatour.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtMaTour = new JTextField("CL009");
		txtMaTour.setBounds(75, 11, 180, 22);
		txtMaTour.setColumns(10);
		panelnhaplieu.add(txtMaTour);
		panelnhaplieu.add(lblmatour);

		JLabel lbltentour = new JLabel("Tên tour :");
		lbltentour.setBounds(10, 50, 80, 28);
		lbltentour.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTenTour = new JTextField("Cao Lãnh - Đồng Tháp");
		txtTenTour.setBounds(75, 50, 180, 22);
		txtTenTour.setColumns(10);
		panelnhaplieu.add(txtTenTour);
		panelnhaplieu.add(lbltentour);

		JLabel lblsoluong = new JLabel("Số chỗ :");
		lblsoluong.setBounds(10, 88, 80, 28);
		lblsoluong.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtsoluongkhach = new JTextField("1");
		txtsoluongkhach.setBounds(75, 88, 180, 22);
		txtsoluongkhach.setColumns(10);
		panelnhaplieu.add(txtsoluongkhach);
		panelnhaplieu.add(lblsoluong);

		JLabel lbltochuc = new JLabel("Tổ chức :");
		lbltochuc.setBounds(10, 127, 80, 28);
		lbltochuc.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtdonvitochuc = new JTextField("MeKong");
		txtdonvitochuc.setBounds(75, 127, 180, 22);
		txtdonvitochuc.setColumns(10);
		panelnhaplieu.add(txtdonvitochuc);
		panelnhaplieu.add(lbltochuc);

		JLabel lbltrangthai = new JLabel("Trạng thái :");
		lbltrangthai.setBounds(10, 166, 80, 28);
		lbltrangthai.setFont(new Font("Tahoma", Font.BOLD, 12));
		txttrangthai = new JTextField("Còn Trống");
		txttrangthai.setBounds(75, 166, 180, 22);
		txttrangthai.setColumns(10);
		panelnhaplieu.add(txttrangthai);
		panelnhaplieu.add(lbltrangthai);

		JLabel lbllichtrinh = new JLabel("Lịch trình :");
		lbllichtrinh.setBounds(10, 205, 80, 28);
		lbllichtrinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtlichTrinh = new JTextField("6 ngày - 6 đêm ngắm sen trong đầm");
		txtlichTrinh.setBounds(75, 205, 180, 22);
		txtlichTrinh.setColumns(10);
		panelnhaplieu.add(txtlichTrinh);
		panelnhaplieu.add(lbllichtrinh);

		JLabel lblgia = new JLabel("Giá tour :");
		lblgia.setBounds(10, 244, 80, 28);
		lblgia.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtgiaTour = new JTextField("600000");
		txtgiaTour.setBounds(75, 244, 180, 22);
		txtgiaTour.setColumns(10);
		panelnhaplieu.add(txtgiaTour);
		panelnhaplieu.add(lblgia);

		JLabel lblphuongtien = new JLabel("Phương tiện :");
		lblphuongtien.setBounds(10, 283, 98, 28);
		lblphuongtien.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtphuongtien = new JTextField("Xe khách");
		txtphuongtien.setBounds(90, 283, 167, 22);
		txtphuongtien.setColumns(10);
		panelnhaplieu.add(txtphuongtien);
		panelnhaplieu.add(lblphuongtien);

		JLabel lblloai = new JLabel("Loại tour :");
		lblloai.setBounds(10, 322, 80, 28);
		lblloai.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtmaLoaiTour = new JTextField("VIP");
		txtmaLoaiTour.setBounds(75, 322, 180, 22);
		txtmaLoaiTour.setColumns(10);
		panelnhaplieu.add(txtmaLoaiTour);
		panelnhaplieu.add(lblloai);

		JLabel lblhdv = new JLabel("Hướng dẫn viên :");
		lblhdv.setBounds(10, 361, 111, 28);
		lblhdv.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtmaHDV = new JTextField("HDV005");
		txtmaHDV.setBounds(112, 361, 144, 22);
		txtmaHDV.setColumns(10);
		panelnhaplieu.add(txtmaHDV);
		panelnhaplieu.add(lblhdv);

		JLabel lblngaydi = new JLabel("Ngày đi :");
		lblngaydi.setBounds(10, 400, 80, 25);
		lblngaydi.setFont(new Font("Tahoma", Font.BOLD, 12));
		ngayKH = new JDateChooser();
		ngayKH.setBounds(75, 400, 180, 25);
		ngayKH.setDateFormatString("dd/MM/yyyy");
		panelnhaplieu.add(ngayKH);
		panelnhaplieu.add(lblngaydi);

		JLabel lblngayve = new JLabel("Ngày về :");
		lblngayve.setBounds(10, 439, 80, 28);
		lblngayve.setFont(new Font("Tahoma", Font.BOLD, 12));
		ngayKT = new JDateChooser();
		ngayKT.setBounds(75, 439, 180, 28);
		ngayKT.setDateFormatString("dd/MM/yyyy");
		panelnhaplieu.add(ngayKT);
		panelnhaplieu.add(lblngayve);

		form = new XemDSKH();
		btnxemds = new JButton("XEM DANH SÁCH KHÁCH HÀNG CỦA TOUR");

		btnxemds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnxemds) {
					form.setVisible(true);
				}
			}
		});

		btnxemds.setBounds(10, 485, 246, 33);
		panelnhaplieu.add(btnxemds);
		btnxemds.setForeground(Color.RED);
		btnxemds.setBackground(SystemColor.window);
		btnxemds.setFont(new Font("Tahoma", Font.BOLD, 10));

		JLabel lblNewLabel_11 = new JLabel("New label");

		JPanel panedb = new JPanel();
		panedb.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panedb.setBounds(266, 0, 1080, 429);
		add(panedb);

		JPanel panelchucnang = new JPanel();

		panelchucnang.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelchucnang.setBounds(266, 440, 1080, 89);
		add(panelchucnang);
		panelchucnang.setLayout(null);

		btntim = new JButton("Tìm");
		btntim.setBounds(330, 32, 70, 23);
		panelchucnang.add(btntim);
		btntim.setBackground(Color.BLUE);
		btntim.setForeground(Color.WHITE);
		btntim.setFont(new Font("Tahoma", Font.BOLD, 12));

		txttimMa = new JTextField();
		txttimMa.setBounds(115, 28, 100, 30);
		panelchucnang.add(txttimMa);
		txttimMa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txttimMa.setColumns(10);

		txttimTen = new JTextField();
		txttimTen.setBounds(220, 28, 100, 30);
		panelchucnang.add(txttimTen);
		txttimTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txttimTen.setColumns(10);

		JLabel lbltim = new JLabel("Tìm kiếm");
		lbltim.setBounds(10, 28, 120, 30);
		panelchucnang.add(lbltim);
		lbltim.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbltim.setIcon(new ImageIcon("img/find2.png"));

		btndatve = new JButton("ĐẶT VÉ");

		btndatve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				if (o.getSource() == btndatve) {
					formdatve.setVisible(true);
				}
			}
		});

		btndatve.setBackground(UIManager.getColor("Button.background"));
		btndatve.setForeground(new Color(0, 0, 0));
		btndatve.setFont(new Font("Tahoma", Font.BOLD, 9));
		btndatve.setBounds(430, 11, 100, 58);
		btndatve.setIcon(new ImageIcon("img/ticket.png"));
		panelchucnang.add(btndatve);

		btnThem = new JButton("THÊM");
		btnThem.setBackground(UIManager.getColor("Button.background"));
		btnThem.setForeground(new Color(0, 0, 0));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnThem.setBounds(540, 11, 100, 58);
		btnThem.setIcon(new ImageIcon("img/them1.png"));
		panelchucnang.add(btnThem);

		btnSua = new JButton("SỬA");
		btnSua.setBackground(UIManager.getColor("Button.background"));
		btnSua.setForeground(new Color(0, 0, 0));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnSua.setBounds(650, 11, 100, 58);
		btnSua.setIcon(new ImageIcon("img/sua.png"));
		panelchucnang.add(btnSua);

		btnXoaTrang = new JButton("XÓA TRẮNG");
		btnXoaTrang.setBackground(UIManager.getColor("Button.background"));
		btnXoaTrang.setForeground(new Color(0, 0, 0));
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnXoaTrang.setBounds(760, 11, 105, 58);
		btnXoaTrang.setIcon(new ImageIcon("img/remove.png"));
		panelchucnang.add(btnXoaTrang);

		btnXoa = new JButton("XÓA");
		btnXoa.setBackground(UIManager.getColor("Button.background"));
		btnXoa.setForeground(new Color(0, 0, 0));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnXoa.setBounds(875, 11, 100, 58);
		btnXoa.setIcon(new ImageIcon("img/remove.png"));
		panelchucnang.add(btnXoa);

		String[] colHeader = { "Mã Tour", "Tên Tour", "Số chỗ đặt", "Nhà Tổ Chức", "Trạng Thái", "Lịch Trình",
				"Giá/người", "Phương Tiện", "Loại Tour", "Hướng Dẫn Viên", "Ngày Khởi Hành", "Ngày Kết Thúc" };
		modelTour = new DefaultTableModel(colHeader, 0);
		panedb.setLayout(null);
		tableTour = new JTable(modelTour);
		JScrollPane scrollPane = new JScrollPane(tableTour);
		scrollPane.setBounds(10, 11, 1060, 377);
		panedb.add(scrollPane);
		tableTour.setRowHeight(25);
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for (Tour t : tour_dao.getalltbTour()) {
			Object[] rowData = { t.getMaTour(), t.getTenTour(), t.getsoluongkhach(), t.getdonvitochuc(),
					t.gettrangthai(), t.getlichTrinh(), t.getgiaTour(), t.getphuongtien(),
					t.getLoaiTour().getmaLoaiTour(), t.getHuongDanVien().getMaHDV(), df.format(t.getNgayKH()),
					df.format(t.getNgayKT()) };
			modelTour.addRow(rowData);
		}

		regex = new Regex();

		listTour = new ArrayList<Tour>();

		listTour = tour_dao.getalltbTour();

		btndau = new JButton(new ImageIcon("img/go-first.png"));
		btndau.setBounds(296, 389, 89, 23);
		panedb.add(btndau);

		btntiep = new JButton(new ImageIcon("img/go-previous.png"));
		btntiep.setBounds(395, 389, 89, 23);
		panedb.add(btntiep);
		add(lblMauTin = new JLabel());
		btnnguoc = new JButton(new ImageIcon("img/go-next.png"));
		btnnguoc.setBounds(494, 389, 89, 23);
		panedb.add(btnnguoc);

		btncuoi = new JButton(new ImageIcon("img/go-last.png"));
		btncuoi.setBounds(593, 389, 89, 23);
		panedb.add(btncuoi);

		tableTour.addMouseListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnSua.addActionListener(this);
		btndau.addActionListener(this);
		btntiep.addActionListener(this);
		btnnguoc.addActionListener(this);
		btncuoi.addActionListener(this);
		btntim.addActionListener(this);
		btnxemds.addActionListener(this);
		btndatve.addActionListener(this);
		tableTour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableTour.getSelectedRow();
				if (row >= 0) {
					mauTinHienHanh = row;
					capNhatThongTinMauTin(mauTinHienHanh);
				}
			}
		});

		mauTinHienHanh = -1;
		tongSoMauTin = tableTour.getRowCount();
		if (tongSoMauTin > 0) {
			mauTinHienHanh = 0;
			capNhatThongTinMauTin(mauTinHienHanh);
		}

	}

	private void capNhatThongTinMauTin(int n) {
		tableTour.setRowSelectionInterval(n, n);
		lblMauTin.setText(mauTinHienHanh + 1 + "/" + tongSoMauTin);
		napLopHocVaoTextfields();
	}

	private void napLopHocVaoTextfields() {
		// TODO Auto-generated method stub
		int row = tableTour.getSelectedRow();
		if (row >= 0) {
			txtMaTour.setText(modelTour.getValueAt(row, 0).toString());
			txtTenTour.setText(modelTour.getValueAt(row, 1).toString());
			txtsoluongkhach.setText(modelTour.getValueAt(row, 2).toString());
			txtdonvitochuc.setText(modelTour.getValueAt(row, 3).toString());
			txttrangthai.setText(modelTour.getValueAt(row, 4).toString());
			txtlichTrinh.setText(modelTour.getValueAt(row, 5).toString());
			txtgiaTour.setText(modelTour.getValueAt(row, 6).toString());
			txtphuongtien.setText(modelTour.getValueAt(row, 7).toString());
			txtmaLoaiTour.setText(modelTour.getValueAt(row, 8).toString());
			txtmaHDV.setText(modelTour.getValueAt(row, 9).toString());
			String dkh[] = modelTour.getValueAt(row, 10).toString().split("/");
			String dkt[] = modelTour.getValueAt(row, 11).toString().split("/");
			ngayKH.setDate(
					new Date(Integer.parseInt(dkh[2]) - 1900, Integer.parseInt(dkh[1]) - 1, Integer.parseInt(dkh[0])));
			ngayKT.setDate(
					new Date(Integer.parseInt(dkt[2]) - 1900, Integer.parseInt(dkt[1]) - 1, Integer.parseInt(dkt[0])));

		}
	}

	public void xoaRong() {
		txtTenTour.setText("");
		txtMaTour.requestFocus();
		txtMaTour.setText("");
		txtmaHDV.setText("");
		txtdonvitochuc.setText("");
		txtgiaTour.setText("");
		txtlichTrinh.setText("");
		txtmaLoaiTour.setText("");
		txtsoluongkhach.setText("");
		txtphuongtien.setText("");
		txttrangthai.setText("");
		ngayKH.setDate(null);
		ngayKT.setDate(null);

	}

	private void xoaHetModel() {
		DefaultTableModel df = (DefaultTableModel) tableTour.getModel();
		df.getDataVector().removeAllElements();
		tableTour.clearSelection();
	}

	private boolean kiemTra() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		if (regex.kiemTraRong(txtMaTour))
			return false;
		/*
		 * if (regex.RegexMaTour(txtMaTour)) return false
		 */;
		if (regex.kiemTraRong(txtTenTour))
			return false;

		if (regex.kiemTraRong(txtsoluongkhach))
			return false;
		if (regex.kiemTraSoInt(txtsoluongkhach))
			return false;
		if (regex.kiemTraRong(txtdonvitochuc))
			return false;
		if (regex.kiemTraRong(txttrangthai))
			return false;
		if (regex.kiemTraRong(txtlichTrinh))
			return false;
		if (regex.kiemTraRong(txtgiaTour))
			return false;
		if (regex.kiemTraSoDouble(txtgiaTour))
			return false;
		if (regex.kiemTraRong(txtphuongtien))
			return false;
		if (regex.kiemTraRong(txtmaLoaiTour))
			return false;
		if (regex.RegexloaiTour(txtmaLoaiTour))
			return false;
		if (regex.kiemTraRong(txtmaHDV))
			return false;
		/*
		 * try { java.util.Date ngaydi = ngayKH.getDate(); String s[] =
		 * df.format(ngaydi).split("/"); LocalDate d1 =
		 * LocalDate.of(Integer.parseInt(s[2]), Integer.parseInt(s[1]),
		 * Integer.parseInt(s[0])); if (d1.isBefore(LocalDate.now())) {
		 * JOptionPane.showMessageDialog(null, "Ngày đi không hợp lệ!"); return false; }
		 * } catch (Exception e) { JOptionPane.showMessageDialog(null,
		 * "Vui lòng chọn ngày đi!"); return false; } try { java.util.Date ngayden =
		 * ngayKT.getDate(); String s1[] = df.format(ngayden).split("/"); LocalDate d2 =
		 * LocalDate.of(Integer.parseInt(s1[2]), Integer.parseInt(s1[1]),
		 * Integer.parseInt(s1[0])); java.util.Date ngayTC = ngayKH.getDate(); String
		 * s[] = df.format(ngayTC).split("/"); LocalDate d1 =
		 * LocalDate.of(Integer.parseInt(s[2]), Integer.parseInt(s[1]),
		 * Integer.parseInt(s[0])); if (d2.isBefore(d1)) {
		 * JOptionPane.showMessageDialog(null, "Ngày về không hợp lệ!"); return false; }
		 * } catch (Exception e) { JOptionPane.showMessageDialog(null,
		 * "Vui lòng chọn ngày về!"); return false; }
		 */
		return true;
	}

	private void NapDLVaoList() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for (Tour t : tour_dao.getalltbTour()) {
			Object[] rowData = { t.getMaTour(), t.getTenTour(), t.getsoluongkhach(), t.getdonvitochuc(),
					t.gettrangthai(), t.getlichTrinh(), t.getgiaTour(), t.getphuongtien(),
					t.getLoaiTour().getmaLoaiTour(), t.getHuongDanVien().getMaHDV(), df.format(t.getNgayKH()),
					df.format(t.getNgayKT()) };
			modelTour.addRow(rowData);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		if (o.equals(btnThem)) {
			if (kiemTra()) {
				String ma = txtMaTour.getText();
				String ten = txtTenTour.getText();
				int slk = Integer.parseInt(txtsoluongkhach.getText());
				String dv = txtdonvitochuc.getText();
				String tt = txttrangthai.getText();
				String lt = txtlichTrinh.getText();
				float gia = Float.parseFloat(txtgiaTour.getText());
				String pt = txtphuongtien.getText();
				String mt = txtmaLoaiTour.getText();
				String hdv = txtmaHDV.getText();
				Date dkh = ngayKH.getDate();
				String s[] = df.format(dkh).split("/");
				Date dkt = ngayKT.getDate();
				String z[] = df.format(dkt).split("/");
				java.sql.Date kh = new java.sql.Date(Integer.parseInt(s[2]) - 1900, Integer.parseInt(s[1]) - 1,
						Integer.parseInt(s[0]));
				java.sql.Date kt = new java.sql.Date(Integer.parseInt(z[2]) - 1900, Integer.parseInt(z[1]) - 1,
						Integer.parseInt(z[0]));
				Tour t = new Tour(ma, ten, slk, dv, tt, lt, gia, pt, new LoaiTour(mt), new HuongDanVien(hdv), kh, kt);

				if (tour_dao.ThemTour(t)) {
					modelTour.addRow(new Object[] { t.getMaTour(), t.getTenTour(), t.getsoluongkhach(),
							t.getdonvitochuc(), t.gettrangthai(), t.getlichTrinh(), t.getgiaTour(), t.getphuongtien(),
							t.getLoaiTour().getmaLoaiTour(), t.getHuongDanVien().getMaHDV(), df.format(t.getNgayKH()),
							df.format(t.getNgayKT()) });
				}

				else {
					JOptionPane.showMessageDialog(this, "Lỗi trùng mã Tour");
				}
			}

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

		}
		if (o.equals(btnSua)) {
			int row = tableTour.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn Tour");
				return;
			} else {
				if (kiemTra()) {
					Tour t = listTour.get(row);
					String ma = txtMaTour.getText();
					String ten = txtTenTour.getText();
					int slk = Integer.parseInt(txtsoluongkhach.getText());
					String dv = txtdonvitochuc.getText();
					String tt = txttrangthai.getText();
					String lt = txtlichTrinh.getText();
					float gia = Float.parseFloat(txtgiaTour.getText());
					String pt = txtphuongtien.getText();
					String mt = txtmaLoaiTour.getText();
					String hdv = txtmaHDV.getText();
					Date dkh = ngayKH.getDate();
					String s[] = df.format(dkh).split("/");
					Date dkt = ngayKT.getDate();
					String z[] = df.format(dkt).split("/");
					java.sql.Date kh = new java.sql.Date(Integer.parseInt(s[2]) - 1900, Integer.parseInt(s[1]) - 1,
							Integer.parseInt(s[0]));
					java.sql.Date kt = new java.sql.Date(Integer.parseInt(z[2]) - 1900, Integer.parseInt(z[1]) - 1,
							Integer.parseInt(z[0]));
					t = new Tour(ma, ten, slk, dv, tt, lt, gia, pt, new LoaiTour(mt), new HuongDanVien(hdv), kh, kt);
					tour_dao.SuaTour(t);

					JOptionPane.showMessageDialog(this, "Sửa thành công");
					modelTour.setValueAt(ma, row, 0);
					modelTour.setValueAt(ten, row, 1);
					modelTour.setValueAt(slk, row, 2);
					modelTour.setValueAt(dv, row, 3);
					modelTour.setValueAt(tt, row, 4);
					modelTour.setValueAt(lt, row, 5);
					modelTour.setValueAt(gia, row, 6);
					modelTour.setValueAt(pt, row, 7);
					modelTour.setValueAt(mt, row, 8);
					modelTour.setValueAt(hdv, row, 9);
					modelTour.setValueAt(dkh, row, 10);
					modelTour.setValueAt(dkt, row, 11);
					listTour.add(row, t);
					listTour.remove(row + 1);

					xoaRong();

				}
			}
		}

		else if (o.equals(btnXoaTrang)) {

			xoaRong();
		}

		else if (o.equals(btnXoa)) {
			if (tableTour.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Hãy chọn Tour cần xóa");
			} else {
				int tl;
				tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa Tour này không ?", "Cảnh báo",
						JOptionPane.YES_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					while (tableTour.getSelectedRowCount() > 0) {
						int index = tableTour.getSelectedRow();
						tour_dao.XoaTour(modelTour.getValueAt(tableTour.getSelectedRow(), 0).toString());
						modelTour.removeRow(index);
					}
				} else
					JOptionPane.showMessageDialog(this, "Không thành công");
			}

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableTour.getSelectedRow();

		txtMaTour.setText(modelTour.getValueAt(row, 0).toString());
		txtTenTour.setText(modelTour.getValueAt(row, 1).toString());
		txtsoluongkhach.setText(modelTour.getValueAt(row, 2).toString());
		txtdonvitochuc.setText(modelTour.getValueAt(row, 3).toString());
		txttrangthai.setText(modelTour.getValueAt(row, 4).toString());
		txtlichTrinh.setText(modelTour.getValueAt(row, 5).toString());
		txtgiaTour.setText(modelTour.getValueAt(row, 6).toString());
		txtphuongtien.setText(modelTour.getValueAt(row, 7).toString());
		txtmaLoaiTour.setText(modelTour.getValueAt(row, 8).toString());
		txtmaHDV.setText(modelTour.getValueAt(row, 9).toString());
		String dkh[] = modelTour.getValueAt(row, 10).toString().split("/");
		String dkt[] = modelTour.getValueAt(row, 11).toString().split("/");
		ngayKH.setDate(
				new Date(Integer.parseInt(dkh[2]) - 1900, Integer.parseInt(dkh[1]) - 1, Integer.parseInt(dkh[0])));
		ngayKT.setDate(
				new Date(Integer.parseInt(dkt[2]) - 1900, Integer.parseInt(dkt[1]) - 1, Integer.parseInt(dkt[0])));

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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (!txttimMa.getText().equals("") || !txttimTen.getText().equals("")) {
			listTour = tour_dao.TimTour(txttimMa.getText(), txttimTen.getText());
			xoaHetModel();
			NapDLVaoList();

		}

	}

}
