package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;


import connectDB.ConnectDB;
import entity.Tour;
import entity.HuongDanVien;

import entity.LoaiTour;


public class Tour_DAO {
	public ArrayList<Tour> getalltbTour(){
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Tour ";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				int soluongkhach = rs.getInt(3);
				String donvitochuc = rs.getString(4);
				String trangthai = rs.getString(5);
				String lichTrinh = rs.getString(6);
				float giaTour = rs.getFloat(7);
				String phuongtien = rs.getString(8);
				LoaiTour maLoaiTour = new LoaiTour(rs.getString(9));
				HuongDanVien MaHDV = new HuongDanVien(rs.getString(10));
				Date NgayKH = rs.getDate(11);
				Date NgayKT = rs.getDate(12);
				Tour tour = new Tour(maTour,tenTour,soluongkhach, donvitochuc, trangthai, lichTrinh, giaTour,phuongtien, maLoaiTour, MaHDV, 
						NgayKH, NgayKT);
				dsTour.add(tour);

			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsTour;
		
	}
	
	public ArrayList<Tour> getTourTheoMa(String maTour1){
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Tour where maTour = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maTour1);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				int soluongkhach = rs.getInt(3);
				String donvitochuc = rs.getString(4);
				String trangthai = rs.getString(5);
				String lichTrinh = rs.getString(6);
				float giaTour = rs.getFloat(7);
				String phuongtien = rs.getString(8);
				LoaiTour maLoaiTour = new LoaiTour(rs.getString(9));
				HuongDanVien MaHDV = new HuongDanVien(rs.getString(10));
				Date NgayKH = rs.getDate(11);
				Date NgayKT = rs.getDate(12);
				Tour tour = new Tour(maTour,tenTour,soluongkhach, donvitochuc, trangthai, lichTrinh, giaTour,phuongtien, maLoaiTour, MaHDV, 
						NgayKH, NgayKT);
				dsTour.add(tour);


			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsTour;
		
	}
	
	public ArrayList<Tour> DSTCoTheDatVe(LocalDate ngayHienTai){ // Hàm này dùng để lấy danh sách tour có ngày khởi hành trước ngày hiện tại
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Tour t where t.ngayKhoiHanh > ? order by ngayKhoiHanh desc";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, ngayHienTai.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				int soluongkhach = rs.getInt(3);
				String donvitochuc = rs.getString(4);
				String trangthai = rs.getString(5);
				String lichTrinh = rs.getString(6);
				float giaTour = rs.getFloat(7);
				String phuongtien = rs.getString(8);
				LoaiTour maLoaiTour = new LoaiTour(rs.getString(9));
				HuongDanVien MaHDV = new HuongDanVien(rs.getString(10));
				Date NgayKH = rs.getDate(11);
				Date NgayKT = rs.getDate(12);
				Tour tour = new Tour(maTour,tenTour,soluongkhach, donvitochuc, trangthai, lichTrinh, giaTour,phuongtien, maLoaiTour, MaHDV, 
						NgayKH, NgayKT);
				dsTour.add(tour);


			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsTour;
	}
	public ArrayList<Tour> LayHetTour(){
		ArrayList<Tour> dsTour = new ArrayList<Tour>();

		 
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Tour order by ngayKhoiHanh desc";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//preparedStatement.setString(1, "hshs");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				int soluongkhach = rs.getInt(3);
				String donvitochuc = rs.getString(4);
				String trangthai = rs.getString(5);
				String lichTrinh = rs.getString(6);
				float giaTour = rs.getFloat(7);
				String phuongtien = rs.getString(8);
				LoaiTour maLoaiTour = new LoaiTour(rs.getString(9));
				HuongDanVien MaHDV = new HuongDanVien(rs.getString(10));
				Date NgayKH = rs.getDate(11);
				Date NgayKT = rs.getDate(12);
				Tour tour = new Tour(maTour,tenTour,soluongkhach, donvitochuc, trangthai, lichTrinh, giaTour,phuongtien, maLoaiTour, MaHDV, 
						NgayKH, NgayKT);
				dsTour.add(tour);

			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsTour;
		
	}
	
public boolean ThemTour(Tour tour) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "insert into Tour values(?,?,?,?,?,?,?,?,?,?,?,?) ";
		int k =0;
		try {

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, tour.getMaTour());
			preparedStatement.setString(2, tour.getTenTour());
			preparedStatement.setInt(3, tour.getsoluongkhach());
			preparedStatement.setString(4, tour.getdonvitochuc());
			preparedStatement.setString(5, tour.gettrangthai());
			preparedStatement.setString(6, tour.getlichTrinh());
			preparedStatement.setFloat(7, tour.getgiaTour());
			preparedStatement.setString(8, tour.getphuongtien());
			preparedStatement.setString(9, tour.getLoaiTour().getmaLoaiTour());
			preparedStatement.setString(10, tour.getHuongDanVien().getMaHDV());
			preparedStatement.setDate(11, tour.getNgayKH());
			preparedStatement.setDate(12, tour.getNgayKT());
			
			k = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k>0;
	}
	public boolean SuaTour(Tour tour) {
		ConnectDB.getInstance();
		Connection con =  ConnectDB.getConnection();
		String sql = "update Tour set tenTour=?, soluongkhach=?, donvitochuc=?, trangthai=?, lichtrinh=?, giaTour=?,"
				+ "phuongtien=?, maLoaiTour=?, MaHDV=?, NgayKH=?, NgayKT=?  where maTour = ?";
		int k =0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setString(1, tour.getMaTour());
			preparedStatement.setString(2, tour.getTenTour());
			preparedStatement.setInt(3, tour.getsoluongkhach());
			preparedStatement.setString(4, tour.getdonvitochuc());
			preparedStatement.setString(5, tour.gettrangthai());
			preparedStatement.setString(6, tour.getlichTrinh());
			preparedStatement.setFloat(7, tour.getgiaTour());
			preparedStatement.setString(8, tour.getphuongtien());
			preparedStatement.setString(9, tour.getLoaiTour().getmaLoaiTour());
			preparedStatement.setString(10, tour.getHuongDanVien().getMaHDV());
			preparedStatement.setDate(11, tour.getNgayKH());
			preparedStatement.setDate(12, tour.getNgayKT());
			k = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k>0; 
	}

	
	public Tour LayTourTheoMaTour(String mt) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Tour where maTour = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, mt);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				int soluongkhach = rs.getInt(3);
				String donvitochuc = rs.getString(4);
				String trangthai = rs.getString(5);
				String lichTrinh = rs.getString(6);
				float giaTour = rs.getFloat(7);
				String phuongtien = rs.getString(8);
				LoaiTour maLoaiTour = new LoaiTour(rs.getString(9));
				HuongDanVien MaHDV = new HuongDanVien(rs.getString(10));
				Date NgayKH = rs.getDate(11);
				Date NgayKT = rs.getDate(12);
				Tour tour = new Tour(maTour,tenTour,soluongkhach, donvitochuc, trangthai, lichTrinh, giaTour,phuongtien, maLoaiTour, MaHDV, 
						NgayKH, NgayKT);
				return tour;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public boolean XoaTour(String maTour) {
		int k=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "delete from Tour where maTour = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maTour);
			k = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return k>0;
	}
	private ArrayList<String> tachChuoiTim(String chuoiTim){
		ArrayList<String> chuoiTach = new ArrayList<String>();
		String chuoi = chuoiTim.trim();
		int t=0;
		for(int i =0;i<chuoi.length();i++) {
			if(i==chuoi.length()-1) {
				chuoiTach.add(chuoi.substring(t,i+1));
				break;
			}
			if(chuoi.codePointAt(i)==32) {		
				if(chuoi.substring(t,i).codePointAt(0)!=32)
				{				
					chuoiTach.add(chuoi.substring(t,i));
					t=i+1;
				}	
			}
		}
		
		return chuoiTach;
	}
	public ArrayList<Tour> TimTour(String maTour, String tenTour) {
		ArrayList<Tour> list = new ArrayList<Tour>();
		PreparedStatement mt = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from Tour where ";
		if(!maTour.equals(""))
			sql += "maTour like '%"+maTour+"%' and ";
		
		if(!tenTour.equals(""))
			sql += "tenTour like N'%"+tenTour+"%' and ";
		
		sql = sql.substring(0, sql.length()-5);
		try {
			mt = con.prepareStatement(sql);
			ResultSet rs = mt.executeQuery();
			while (rs.next()) {
				Tour tour = new Tour();
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				int soluongkhach = rs.getInt(3);
				String donvitochuc = rs.getString(4);
				String trangthai = rs.getString(5);
				String lichTrinh = rs.getString(6);
				float giaTour = rs.getFloat(7);
				String phuongtien = rs.getString(8);
				LoaiTour maLoaiTour = new LoaiTour(rs.getString(9));
				HuongDanVien MaHDV = new HuongDanVien(rs.getString(10));
				Date NgayKH = rs.getDate(11);
				Date NgayKT = rs.getDate(12);
				tour = new Tour(ma,ten,soluongkhach, donvitochuc, trangthai, lichTrinh, giaTour,phuongtien, maLoaiTour, MaHDV, 
						NgayKH, NgayKT);
				list.add(tour);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

}
