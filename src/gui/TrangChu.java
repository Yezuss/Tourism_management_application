package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import dao.DAO_NhanVien;
import entity.NhanVien;

import java.awt.SystemColor;
import javax.swing.UIManager;

public class TrangChu extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTabbedPane tabbedPane;
	private JPanel tieudepane;
	private NhanVien nhanvien;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TrangChu() {
		
		setTitle("QUẢN LÝ TOUR DU LỊCH");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(0,0,1390, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(UIManager.getColor("Button.light"));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.controlLtHighlight);
		tabbedPane.setBorder(new LineBorder(SystemColor.windowBorder, 4, true));
		tabbedPane.setBounds(0, 118, 1360, 572);
		panel.add(tabbedPane);
		
		tieudepane = new JPanel();
		tieudepane.setBackground(SystemColor.controlLtHighlight);
		tieudepane.setBorder(new LineBorder(SystemColor.windowBorder, 4, true));
		tieudepane.setBounds(0, 11, 1360, 107);
		panel.add(tieudepane);
		
		JLabel lbdl = new JLabel("QUẢN LÝ TOUR DU LỊCH");
		lbdl.setForeground(Color.ORANGE);
		lbdl.setFont(new Font("Tahoma", Font.BOLD, 68));
		lbdl.setBounds(234, 11, 865, 85);
		tieudepane.add(lbdl);
		QuanLyTour quanLyTour = new QuanLyTour();
		QuanLyKhachHang quanLyKH =new QuanLyKhachHang();
		QuanLyNhanVien quanLyNV =new QuanLyNhanVien();
		QuanLyHuongDanVien quanLyHDV =new QuanLyHuongDanVien();
		quanLyTour.setBackground(SystemColor.textHighlightText);
		tabbedPane.addTab("Quản Lý Tour",null,  quanLyTour);
		tabbedPane.addTab("Quản Lý Khách Hàng",null,  quanLyKH);
		tabbedPane.addTab("Quản Lý Nhân viên",null,  quanLyNV);
		tabbedPane.addTab("Quản Lý Hướng Dẫn Viên",null,  quanLyHDV);
	}



	

}
