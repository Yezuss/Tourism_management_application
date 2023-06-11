package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dao.DangNhap_DAO;
import entity.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class DangNhap extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private JPanel contentPane;
	private JPasswordField txtPass;
	private JTextField txtUsername;
	private JButton btnThoat;
	private JButton btnDangNhap;

	public DangNhap() {
		setTitle("Đăng nhập");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(487, 300);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		this.add(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("Tài khoản:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(28, 53, 109, 31);
		contentPane.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setBounds(166, 53, 218, 31);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUsername.setText("TK7899");
		contentPane.add(txtUsername);

		JLabel lblPassword = new JLabel("Mật khẩu:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(29, 125, 108, 27);
		contentPane.add(lblPassword);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(166, 125, 218, 31);
		panel.setLayout(null);
		contentPane.add(panel);

		txtPass = new JPasswordField();
		txtPass.setBounds(0, 0, 178, 31);
		txtPass.setBorder(null);
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPass.setEchoChar('*');
		txtPass.setText("admin");
		panel.add(txtPass);

		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDangNhap.setBackground(Color.PINK);
		btnDangNhap.setBounds(261, 183, 155, 40);
		contentPane.add(btnDangNhap);

		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoat.setBackground(Color.PINK);
		btnThoat.setBounds(61, 183, 123, 40);
		contentPane.add(btnThoat);

		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);

	}

	public static void main(String[] args) {

		new DangNhap().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * Object o = e.getSource(); String maNV = txtUsername.getText(); String matkhau
		 * = new String(txtPass.getPassword()); DangNhap_DAO dangNhap = new
		 * DangNhap_DAO(); if (o.equals(btnDangNhap)) { if(valid()) { if
		 * (dangNhap.Login(maNV, matkhau) != null) { setVisible(false); new TrangChu(new
		 * NhanVien(maNV)).setVisible(true); } else JOptionPane.showMessageDialog(this,
		 * "Tài khoản hoặc mật khẩu không chính xác"); } }else { System.exit(0); }}
		 */
		
	}
	public Boolean valid() {
		String taiKhoan = txtUsername.getText().trim();
		if (taiKhoan.equals("")) {
			JOptionPane.showMessageDialog(this, "Tài khoản không được để trống");
			return false;
		} else if (new String(txtPass.getPassword()).equals("")) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập mật khẩu");
			return false;
		}
		return true;
	}

}
