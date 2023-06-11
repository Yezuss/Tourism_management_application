package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HuongDanVien;
import entity.NhanVien;
import entity.TaiKhoan;


public class DAO_NhanVien {
	public ArrayList<NhanVien> getAllNV() {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhanVien";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String sdt = rs.getString(3);
				String email = rs.getString(4);
				String tuoi = rs.getString(5);
				boolean gioitinh = rs.getBoolean(6);
				String diachi = rs.getString(7);
				String mk = rs.getString(8);
			
				NhanVien nv = new NhanVien(maNV, tenNV, sdt,  email, tuoi,  gioitinh, diachi,mk);
				dsNV.add(nv);
				 

			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsNV;
	}
	
	
	
	
	public NhanVien getNhanVien(String ma) {
		NhanVien nv =new NhanVien();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement p = con.prepareStatement("select * from NhanVien where MaNV = ?");
			p.setString(1, ma);
			ResultSet r = p.executeQuery();
			r.next();
			nv = new NhanVien(r.getString("MaNV").trim(), r.getString("tenNV").trim());
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nv;
	}
	
	
	
	
	
	public boolean createNV(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement st = null;
		int n=0;
		try {
			st = con.prepareStatement(" insert into NhanVien values (?,?,?,?,?,?,?,?)");
			
			st.setString(1, nv.getMaNV());
			st.setString(2, nv.getTenNV());
			st.setString(3, nv.getSdt());
			st.setString(4, nv.getEmail());
			st.setString(5, nv.getTuoi());
			st.setBoolean(6, nv.isGioiTinh());
			st.setString(7, nv.getDiaChi());
			st.setString(8, nv.getMatkhau());
			
			
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
	public boolean XoaNV(String maNV) {
		int k=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "delete from NhanVien where maNV = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maNV);
			k = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return k>0;
	}
}
