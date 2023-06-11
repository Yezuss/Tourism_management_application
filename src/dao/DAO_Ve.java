package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;
import entity.Tour;
import entity.Ve;

public class DAO_Ve {
	public ArrayList<Ve> getalltbVe(){
		ArrayList<Ve> dsVe = new ArrayList<Ve>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Ve ";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//preparedStatement.setString(1, maTour);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maVe = rs.getString(1);
				Date ngayDatVe = rs.getDate(2);
				//Tour  tour = new Tour(rs.getString(5));
				Ve ve = new Ve(maVe,ngayDatVe,new Tour(rs.getString(5)),new KhachHang(rs.getString(19)),new NhanVien(rs.getString(19)));
				dsVe.add(ve);

			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsVe;
	}
	public ArrayList<Ve> getVeTheoMaTour(String maTour){
		ArrayList<Ve> dsVe = new ArrayList<Ve>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Ve v join Tour t on v.maTour = t.maTour join KhachHang kh on v.maKH=kh.maKH join NhanVien nv on nv.maNV = v.maNV    where v.maTour = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maTour);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				/*
				 * String maVe = rs.getString(1); Date ngayDatVe = rs.getDate(2); //Tour tour =
				 * new Tour(rs.getString(5)); Ve ve = new Ve(maVe,ngayDatVe,new
				 * Tour(rs.getString(7)),new KhachHang(rs.getString(19)),new
				 * NhanVien(rs.getString(26))); dsVe.add(ve);
				 */
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsVe;
		
	}
	public ArrayList<Ve> DanhSachVeTheoMaTour(String maTour){
		ArrayList<Ve> dsVe = new ArrayList<Ve>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Ve v where v.maTour = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maTour);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				/*
				 * String maVe = rs.getString(1); Date ngayDatVe = rs.getDate(2); KhachHang
				 * khachHang = new KhachHang(rs.getString(3)); NhanVien nhanVien = new
				 * NhanVien(rs.getString(4)); Tour tour = new Tour(rs.getString(5));
				 * 
				 * Ve ve = new Ve(maVe,ngayDatVe,khachHang, nhanVien,tour); dsVe.add(ve);
				 */
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsVe;
	}
	public int LayMaVeLonNhat(String maTour) {
		int ma =0;
		ArrayList<Ve> listVe = DanhSachVeTheoMaTour(maTour);
		if(listVe.size()>0)
			ma = listVe.size();
		return ma;
	}
	
	public boolean ThemVe(Ve ve) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "insert into Ve values(?,?,?,?,?) ";
		int k =0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, ve.getMaVe());
			preparedStatement.setDate(2,ve.getNgayDatVe());
			preparedStatement.setString(3, ve.getKhachhang().getMaKH());
			preparedStatement.setString(4, ve.getNhanvien().getMaNV());
			preparedStatement.setString(5, ve.getTour().getMaTour());
			k = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k>0;
	}
}
