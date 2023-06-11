package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiTour;

public class LoaiTour_DAO {
	public ArrayList<LoaiTour> layHetLoaiTour(){
		ArrayList<LoaiTour> dsLoaiTour = new ArrayList<LoaiTour>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from LoaiTour";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maLoaiTour = rs.getString(1);
				String tenLoaiTour = rs.getString(2);
				LoaiTour loaiTour = new LoaiTour(maLoaiTour,tenLoaiTour);
				dsLoaiTour.add(loaiTour);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsLoaiTour;
		
	}
}
