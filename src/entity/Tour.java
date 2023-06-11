package entity;

import java.sql.Date;


public class Tour {
	private String maTour;
	private String tenTour;
	private float giaTour;
	private int soluongkhach;
	private Date NgayKH;
	private Date NgayKT;
	private String donvitochuc;
	private String trangthai;
	private String lichTrinh;
	private HuongDanVien MaHDV;
	private String phuongtien;
	private LoaiTour maLoaiTour;
	public Tour() {
		
		super();
	}
	public Tour(String tenTour) {
		this.tenTour = tenTour;
		
	}
	public Tour(String maTour, String tenTour,int soluongkhach, String donvitochuc, String trangthai, String lichTrinh, 
			float giaTour, String phuongtien, LoaiTour maLoaiTour,  HuongDanVien MaHDV, Date dkh, Date dkt) 
	{
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.giaTour = giaTour;
		this.soluongkhach = soluongkhach;
		this.NgayKH = dkh;
		this.NgayKT = dkt;
		this.donvitochuc = donvitochuc;
		this.trangthai = trangthai;
		this.lichTrinh = lichTrinh;
		this.MaHDV = MaHDV;
		this.phuongtien = phuongtien;
		this.maLoaiTour = maLoaiTour;
	}

	public Tour(String maTour, String tenTour, float giaTour,
			Date NgayKH, Date NgayKT) {
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.giaTour = giaTour;
		this.NgayKH = NgayKH;
		this.NgayKT = NgayKT;
		
	}
	
	public Tour(String maTour, String tenTour,  float giaTour) {
		this.tenTour = tenTour;
		this.maTour = maTour;
		this.giaTour = (float) giaTour;
		
	}
	public HuongDanVien getHuongDanVien() {
		return MaHDV;
	}
	public void setHuongDanVien(HuongDanVien MaHDV) {
		this.MaHDV = MaHDV;
	}
	public LoaiTour getLoaiTour() {
		return maLoaiTour;
	}
	public void setLoaiTour(LoaiTour maLoaiTour) {
		this.maLoaiTour = maLoaiTour;
	}
	public String getMaTour() {
		return maTour;
	}
	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}
	public String getTenTour() {
		return tenTour;
	}
	public void setTenTour(String tenTour) {
		this.tenTour = tenTour;
	}
	public float getgiaTour() {
		return giaTour;
	}
	public void setgiaTour(float giaTour) {
		this.giaTour = giaTour;
	}
	public int getsoluongkhach() {
		return soluongkhach;
	}
	public void setsoluongkhach(int soluongkhach) {
		this.soluongkhach = soluongkhach;
	}
	public Date getNgayKH() {
		return NgayKH;
	}
	public void setNgayKH(Date NgayKH) {
		this.NgayKH = NgayKH;
	}
	public Date getNgayKT() {
		return NgayKT;
	}
	public void setNgayKT(Date NgayKT) {
		this.NgayKT = NgayKT;
	}
	public String getdonvitochuc() {
		return donvitochuc;
	}
	public void setdonvitochuc(String donvitochuc) {
		this.donvitochuc = donvitochuc;
	}
	public String gettrangthai() {
		return trangthai;
	}
	public void settrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public String getlichTrinh() {
		return lichTrinh;
	}
	public void setlichTrinh(String lichTrinh) {
		this.lichTrinh = lichTrinh;
	}
	public String getphuongtien() {
		return phuongtien;
	}
	public void setphuongtien(String phuongtien) {
		this.phuongtien = phuongtien;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTour == null) ? 0 : maTour.hashCode());
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
		Tour other = (Tour) obj;
		if (maTour == null) {
			if (other.maTour != null)
				return false;
		} else if (!maTour.equals(other.maTour))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Tour [maTour=" + maTour + ", tenTour=" + tenTour + ", giaTour=" + giaTour + ", soluongkhach="
				+ soluongkhach + ", NgayKH=" + NgayKH + ", NgayKT=" + NgayKT + ", donvitochuc=" + donvitochuc
				+ ", trangthai=" + trangthai + ", lichTrinh=" + lichTrinh + ", MaHDV=" + MaHDV + ", phuongtien="
				+ phuongtien + ", maLoaiTour=" + maLoaiTour + "]";
	}
	
	
	
	
}
