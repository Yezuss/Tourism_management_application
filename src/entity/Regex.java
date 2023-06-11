package entity;

import java.io.Serializable;
import java.sql.SQLData;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Regex implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean RegexDiaChi(JTextField txtDiaChi2) {
		String input = txtDiaChi2.getText();
		String regex = "^[a-zA-Z0-9À-Ỵà-ỵ//]+(([',. -][a-zA-Z0-9À-Ỵà-ỵ //])?[a-zA-Z0-9À-Ỵà-ỵ //]*)*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Nhập sai vui lòng nhập lại địa chỉ");
			txtDiaChi2.requestFocus();
			txtDiaChi2.selectAll();
			return true;
		} else
			return false;
	}
	
	

	 

	public boolean RegexTen(JTextField txtTen2) {
		String input = txtTen2.getText();
		String regex = "^[a-zA-Z0-9À-Ỵà-ỵ]+(([',. -][a-zA-Z0-9À-Ỵà-ỵ ])?[a-zA-Z0-9À-Ỵà-ỵ ]*)*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Nhập sai tên (cú pháp vd:Tạ Thị Đẹt)");
			txtTen2.requestFocus();
			txtTen2.selectAll();
			return true;
		} else
			return false;
	}

	public boolean RegexTentour(JTextField txtTentour) {
		String input = txtTentour.getText();
		String regex = "^[a-zA-Z0-9À-Ỵà-ỵ]+(([',. -][a-zA-Z0-9À-Ỵà-ỵ ])?[a-zA-Z0-9À-Ỵà-ỵ ]*)*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Nhập sai tên tour");
			txtTentour.requestFocus();
			txtTentour.selectAll();
			return true;
		} else
			return false;
	}
	
	public boolean RegexMaTour(JTextField txttour) {
		String input = txttour.getText();
		String regex = "^[a-zA-Z0-9À-Ỵà-ỵ]*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập lại mã tour ");
			txttour.requestFocus();
			txttour.selectAll();
			return true;
		} else
			return false;
	}
	public boolean RegexloaiTour(JTextField txtloaitour) {
		String input = txtloaitour.getText();
		String regex = "(VIP)||(BASIC)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập lại loại tour ");
			txtloaitour.requestFocus();
			txtloaitour.selectAll();
			return true;
		} else
			return false;
	}
	public boolean kiemTraSoInt(JTextField txtTuoi2) {
		try {
			int x = Integer.parseInt(txtTuoi2.getText());
			if (x < 0) {
				JOptionPane.showMessageDialog(null, "Nhập sai số lượng(Phải lớn hơn 0)");
				return true;
			}
			return false;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Nhập sai số lượng(phải nhập số)");
			return true;
		}
	}

	/*
	 * public boolean kiemTraNgadi(SQLData modelNgay) { long millis =
	 * System.currentTimeMillis(); Date today = new Date(millis); Date ngaySinh =
	 * (Date) modelNgay.getValue(); if (ngaySinh.compareTo(today) > 0) {
	 * JOptionPane.showMessageDialog(null,
	 * "Dữ liệu Ngày sản xuất không hợp lệ phải trước ngày hiện tại"); return true;
	 * } else return false;
	 * 
	 * }
	 */
	public boolean kiemTraSoDouble(JTextField txtTuoi2) {
		try {
			double x = Double.parseDouble(txtTuoi2.getText());
			if (x < 0) {
				JOptionPane.showMessageDialog(null, "Nhập sai dữ liệu Đơn giá(Phải lớn hơn 0)");
				return true;
			}
			return false;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Nhập sai giá(phải nhập số)");
			return true;
		}
	}

	public boolean RegexMa(JTextField txtMa2) {
		String input = txtMa2.getText();
		String regex = "^[A-Z]{2}[0-9]{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập mã lại theo cú pháp vd: AB1234");
			txtMa2.requestFocus();
			txtMa2.selectAll();
			return true;
		} else
			return false;
	}
	public boolean RegexMaHDV(JTextField txtHDV) {
		String input = txtHDV.getText();
		String regex = "^[A-Z]{3}[0-9]{3}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập mã lại theo cú pháp vd: ABC123");
			txtHDV.requestFocus();
			txtHDV.selectAll();
			return true;
		} else
			return false;
	}
	public boolean RegexGmail(JTextField txtgmail) {
		String input = txtgmail.getText();
		String regex = "^[A-Za-z][A-Za-z0-9]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Email phải là kiểu định dạng Email (abc@xyz.com)");
			txtgmail.requestFocus();
			txtgmail.selectAll();
			return true;
		} else
			return false;
	}
	public boolean kiemTraRong(JTextField txt) {
		if (txt.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập dự liệu vào !");
			txt.requestFocus();
			return true;
		}
		return false;
	}

	public boolean kiemTraTuoi(JTextField txtTuoi) {
		try {
			int x = Integer.parseInt(txtTuoi.getText());
			if (x < 0) {
				JOptionPane.showMessageDialog(null, "Nhập sai dữ liệu ()");
				return true;
			}
			return false;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Nhập sai vui lòng nhập lại");
			return true;
		}
	}

	public boolean RegexSDT(JTextField txtSDT) {
		String input = txtSDT.getText();
		String regex = "^[0-9]{9,10}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Bạn đã nhập sai số điện thoại hãy nhập lại (cú pháp vd:0987654321");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return true;
		} else
			return false;
	}

	public boolean regexSoLuong(JTextField txtSoluong) {
		String input = txtSoluong.getText();
		String regex = "^[0-9]{2}";
		if(!input.matches(regex))
		{	JOptionPane.showMessageDialog(null, "Vui lòng nhập lại số lượng ");
			txtSoluong.requestFocus();
			txtSoluong.selectAll();
			return true;
		}
		return false;
		
	}

	
}
