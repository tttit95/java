package Model.Bean;

public class NhanVienBean {
	private String manv;
	private String hoten;
	private String ngaysinh;
	private float hsl;
	private int phucap;
	
	
	
	public NhanVienBean(String manv, String hoten, String ngaysinh, float hsl, int phucap) {
		super();
		this.manv = manv;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.hsl = hsl;
		this.phucap = phucap;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public float getHsl() {
		return hsl;
	}
	public void setHsl(float hsl) {
		this.hsl = hsl;
	}
	public int getPhucap() {
		return phucap;
	}
	public void setPhucap(int phucap) {
		this.phucap = phucap;
	}
	
	
}
