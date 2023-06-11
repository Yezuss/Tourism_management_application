package entity;

public class TaiKhoan {
	private String maTK;
	private String tenTK;
	private String matkhau;
	public String getMaTK() {
		return maTK;
	}
	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}
	public String getTenTK() {
		return tenTK;
	}
	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public TaiKhoan(String maTK, String tenTK, String matkhau) {
		super();
		this.maTK = maTK;
		this.tenTK = tenTK;
		this.matkhau = matkhau;
	}
	public TaiKhoan() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTK == null) ? 0 : maTK.hashCode());
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
		TaiKhoan other = (TaiKhoan) obj;
		if (maTK == null) {
			if (other.maTK != null)
				return false;
		} else if (!maTK.equals(other.maTK))
			return false;
		return true;
	}
	public TaiKhoan(String maTK) {
		super();
		this.maTK = maTK;
	}
	@Override
	public String toString() {
		return "TaiKhoan [maTK=" + maTK + ", tenTK=" + tenTK + ", matkhau=" + matkhau + "]";
	}
	
}

