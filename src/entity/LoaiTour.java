package entity;

public class LoaiTour {
	private String maLoaiTour , tenLoaiTour;

	public LoaiTour(String maLoaiTour) {
		super();
		this.maLoaiTour = maLoaiTour;
	}
	
	public String getmaLoaiTour() {
		return maLoaiTour;
	}

	

	public void setmaLoaiTour(String maLoaiTour) {
		this.maLoaiTour = maLoaiTour;
	}

	public String getTenLoaiTour() {
		return tenLoaiTour;
	}

	public void setTenLoaiTour(String tenLoaiTour) {
		this.tenLoaiTour = tenLoaiTour;
	}

	
	public LoaiTour(String maLoaiTour, String tenLoaiTour) {
		super();
		this.maLoaiTour = maLoaiTour;
		this.tenLoaiTour = tenLoaiTour;
	}

	@Override
	public String toString() {
		return "LoaiTour [maLoaiTour=" + maLoaiTour + ", tenLoaiTour=" + tenLoaiTour + "]";
	}
	
}
