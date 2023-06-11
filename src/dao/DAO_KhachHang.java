package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.KhachHang;

public class DAO_KhachHang {


	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
		try {

			PreparedStatement p = con.prepareStatement("select * from KhachHang");
			ResultSet rs = p.executeQuery();
		
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String tuoi = rs.getString(5);
				boolean gioitinh = rs.getBoolean(6);
				String email = rs.getString(4);
				String sdt = rs.getString(3);
				String diachi = rs.getString(7);
				KhachHang kh = new KhachHang(maKH, tenKH, sdt, email, tuoi, gioitinh, diachi);
				dsKH.add(kh);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsKH;
	}

	public boolean createKH(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement st = null;
		int n=0;
		try {
			st = con.prepareStatement(" insert into KhachHang values (?,?,?,?,?,?,?)");
			
			st.setString(1, kh.getMaKH());
			st.setString(2, kh.getTenKH());
			st.setString(4, kh.getEmail());
			st.setString(7, kh.getDiaChi());
			st.setString(3, kh.getSdt());
			st.setString(5, kh.getTuoi());
			st.setBoolean(6, kh.isGioiTinh());
			n = st.executeUpdate();
			} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}
		return n>0;
	}

	public boolean update(KhachHang khachhang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(
					"update KhachHang set tenKH=?,sdt=?,tuoi=?,email=?,gioiTinh=?,diaChi=? where maKH=?");
			st.setString(1, khachhang.getMaKH());
			st.setString(2, khachhang.getTenKH());
			st.setString(4, khachhang.getEmail());
			st.setString(7, khachhang.getDiaChi());
			st.setString(3, khachhang.getSdt());
			st.setString(5, khachhang.getTuoi());
			st.setBoolean(6, khachhang.isGioiTinh());
			int n = st.executeUpdate();
			if (n > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	public boolean xoaKH(String maKH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete KhachHang where maKH = ?");
			stmt.setString(1, maKH);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	
	public ArrayList<KhachHang> geTimKH(String maKhachHang, String tenKhachHang) {
		ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();
		PreparedStatement stmt = null;
		Connection con = new ConnectDB().getConnection();
		String sql = "select * from LaoDong where ";
		if(!maKhachHang.equals(""))
			sql += "maKH like '%"+maKhachHang+"%' and ";
		
		if(!tenKhachHang.equals(""))
			sql += "tenKH like N'%"+tenKhachHang+"%' and ";
		
		sql = sql.substring(0, sql.length()-5);
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String tuoi = rs.getString(5);
				boolean gioitinh = rs.getBoolean(6);
				String email = rs.getString(4);
				String sdt = rs.getString(3);
				String diachi = rs.getString(7);
				KhachHang k = new KhachHang(maKH, tenKH, sdt, email, tuoi, gioitinh, diachi);
				listKH.add(k);			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listKH;
	}
	public ArrayList<KhachHang> getKhachHangthemaKH(String id) {
		ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from KhachHang where maKH = N'" + id + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String tuoi = rs.getString(5);
				boolean gioitinh = rs.getBoolean(6);
				String email = rs.getString(4);
				String sdt = rs.getString(3);
				String diachi = rs.getString(7);
				KhachHang k = new KhachHang(maKH, tenKH, sdt, email, tuoi, gioitinh, diachi);
				kh.add(k);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}
}
