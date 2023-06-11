package dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import connectDB.ConnectDB;

import entity.HuongDanVien;



public class DAO_HuongDanVien {
	public ArrayList<HuongDanVien> getallHuongDanVien(){
		ArrayList<HuongDanVien> dsHDV = new ArrayList<HuongDanVien>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from  HuongDanVien ";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maHDV = rs.getString(1);
				String tenHDV = rs.getString(2);
				Date ngaysinh = rs.getDate(3);
				boolean gioiTinh = rs.getBoolean(4);
				String diaChi = rs.getString(5);
				String sdt = rs.getString(6);
			
				HuongDanVien hdv = new HuongDanVien(maHDV,tenHDV,ngaysinh,gioiTinh,diaChi,sdt);
				dsHDV.add(hdv);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsHDV;
	}
	
	public boolean themCT(HuongDanVien hdv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "insert into HuongDanVien values(?,?,?,?,?,?) ";
		int k =0;
		try {
			

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, hdv.getMaHDV());
			stmt.setString(2, hdv.getHoten());
			stmt.setDate(3, hdv.getNgaysinh());
			stmt.setBoolean(4, hdv.isGioiTinh());
			stmt.setString(5, hdv.getDiaChi());
			 stmt.setString(6, hdv.getSdt());
			
		
			k = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k>0;
	}
	public boolean update(HuongDanVien huongDanVien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(
					"update KhachHang set tenKH=?,sdt=?,tuoi=?,email=?,gioiTinh=?,diaChi=? where maKH=?");
			st.setString(1, huongDanVien.getMaHDV());
			st.setString(2, huongDanVien.getHoten());
			st.setString(3, huongDanVien.getDiaChi());
			st.setString(4, huongDanVien.getSdt());
			st.setDate(5, huongDanVien.getNgaysinh());
			st.setBoolean(6, huongDanVien.isGioiTinh());
			int n = st.executeUpdate();
			if (n > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean xoaHDV(String maHDV) throws SQLException {
		Connection a = connectDB.ConnectDB.getConnection();// Tao Ket Noi
		String sql = "delete KhachHang where maHDV='" + maHDV + "'";
		PreparedStatement pstm = a.prepareStatement(sql);
		if (pstm.executeUpdate() > 0) {
			JOptionPane.showMessageDialog(null, "Xóa thành công Hướng dẫn viên " + maHDV);
			return true;
		}
		return false;
	}
}
