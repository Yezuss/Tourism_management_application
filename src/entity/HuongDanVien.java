 package entity;

import java.sql.Date;


public class HuongDanVien {
private String maHDV;
private String hoten;
private Date ngaysinh;
private boolean gioiTinh;
private String diaChi;
private String sdt;


public String getMaHDV() {
	return maHDV;
}
public void setMaHDV(String MaHDV) {
	this.maHDV = MaHDV;
}
public String getHoten() {
	return hoten;
}
public void setHoten(String hoten) {
	this.hoten = hoten;
}
public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}
public Date getNgaysinh() {
	return ngaysinh;
}
public void setNgaysinh(Date ngaysinh) {
	this.ngaysinh = ngaysinh;
}
public boolean isGioiTinh() {
	return gioiTinh;
}
public void setGioiTinh(boolean gioiTinh) {
	this.gioiTinh = gioiTinh;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}

public HuongDanVien(String maHDV, String hoten, Date ngaysinh, boolean gioiTinh, String diaChi, String sdt) {
	super();
	this.maHDV = maHDV;
	this.hoten = hoten;
	this.ngaysinh = ngaysinh;
	this.gioiTinh = gioiTinh;
	this.diaChi = diaChi;
	this.sdt = sdt;
}
public HuongDanVien() {
	super();
}
public HuongDanVien(String maHDV) {
	super();
	this.maHDV = maHDV;
}

public HuongDanVien(String ma, String ten, java.util.Date ns, boolean gt, String dc, String sdt2) {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "HuongDanVien [maHDV=" + maHDV + ", hoten=" + hoten + ", ngaysinh=" + ngaysinh
			+ ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", sdt=" + sdt + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((hoten == null) ? 0 : hoten.hashCode());
	result = prime * result + ((maHDV == null) ? 0 : maHDV.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	HuongDanVien other = (HuongDanVien) obj;
	if (hoten == null) {
		if (other.hoten != null)
			return false;
	} else if (!hoten.equals(other.hoten))
		return false;
	if (maHDV == null) {
		if (other.maHDV != null)
			return false;
	} else if (!maHDV.equals(other.maHDV))
		return false;
	return true;
}
	
	
	
}
