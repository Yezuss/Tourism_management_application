package entity;

import java.sql.Date;


public class Ve {
	private String maVe;
	private Date ngayDatVe;
	Tour maTour;
	KhachHang maKH;
	NhanVien maNV;
	public Ve(String maVe, Date ngayDatVe, Tour maTour, KhachHang maKH,NhanVien maNV) {
		super();
		this.maVe = maVe;
		this.ngayDatVe = ngayDatVe;
		this.maTour = maTour;
		this.maKH = maKH;
		this.maNV = maNV;
	}
	public Ve(String maVe, Date ngayDatVe, KhachHang maKH, NhanVien maNV, Tour maTour) {
		super();
		this.maVe = maVe;
		this.ngayDatVe = ngayDatVe;
		this.maTour = maTour;
		this.maKH = maKH;
		this.maNV = maNV;
	}
	public Ve(String maVe, Date ngayDatVe, Tour maTour, KhachHang kh) {
		super();
		this.maVe = maVe;
		this.ngayDatVe = ngayDatVe;
		this.maTour = maTour;
		this.maKH = maKH;
	}
	public String getMaVe() {
		return maVe;
	}
	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}
	public Date getNgayDatVe() {
		return ngayDatVe;
	}
	public void setNgayDatVe(Date ngayDatVe) {
		this.ngayDatVe = ngayDatVe;
	}
	public Tour getTour() {
		return maTour;
	}
	public void setTour(Tour tour) {
		this.maTour = maTour;
	}
	public KhachHang getKhachhang() {
		return maKH;
	}
	public void setKhachhang(KhachHang khachhang) {
		this.maKH = maKH;
	}
	public NhanVien getNhanvien() {
		return maNV;
	}
	public void setNhanvien(NhanVien nhanvien) {
		this.maNV = maNV;
	}
	
	
	
}
