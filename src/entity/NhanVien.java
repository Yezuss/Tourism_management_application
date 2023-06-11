package entity;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private String sdt;
	private String email;
	private String tuoi;
	private boolean gioiTinh;
	private String diaChi;
	private String matkhau;
	
	public NhanVien() {
		super();
	}
	
	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
		
		
	}
	
	public NhanVien(String maNV, String matkhau) {
		super();
		this.maNV = maNV;
		this.matkhau = matkhau;
	}



	public NhanVien(String maNV, String tenNV, String sdt, String email, String tuoi, boolean gioiTinh,
			String diaChi, String matkhau) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.sdt = sdt;
		this.email = email;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.matkhau = matkhau;
	}

	public NhanVien(String maNV, String tenNV, String sdt, String email, String tuoi, boolean gioiTinh,
			String diaChi) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.sdt = sdt;
		this.email = email;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
	
	}

	
	
	public String getMaNV() {
		return maNV;
	}



	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}




	public String getTenNV() {
		return tenNV;
	}



	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}



	public String getSdt() {
		return sdt;
	}



	public void setSdt(String sdt) {
		this.sdt = sdt;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTuoi() {
		return tuoi;
	}



	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
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
	
	public String getMatkhau() {
		return matkhau;
	}



	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}




	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
		result = prime * result + ((tenNV == null) ? 0 : tenNV.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		if (tenNV == null) {
			if (other.tenNV != null)
				return false;
		} else if (!tenNV.equals(other.tenNV))
			return false;
		return true;
	}
}
