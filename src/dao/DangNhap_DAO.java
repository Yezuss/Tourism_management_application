package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.NhanVien;

public class DangNhap_DAO {
	public boolean kiemtra(String maNV, String matkhau) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement p=con.prepareStatement("select MaNV from NhanVien where MaNV=? and matkhau=?");
			p.setString(1, maNV);
			p.setString(2, matkhau);
			ResultSet r=p.executeQuery();
			while(r.next()) {
				if(!r.getString("MaNV").equalsIgnoreCase(""))
					return true;
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	public NhanVien Login(String username, String password) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from TaiKhoan where maNV = ? and matKhau = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				NhanVien tk = new NhanVien(rs.getString(1), rs.getString(2));
				return tk;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return null;
	}
}

