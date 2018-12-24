package model.bean;

import java.sql.Date;

public class BaiHat {
	private int ma;
	private String ten;
	private Date ngaytao;
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Date getNgaytao() {
		return ngaytao;
	}
	
	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public BaiHat(int ma, String ten, Date ngaytao) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.ngaytao = ngaytao;
	}
	
	public BaiHat() {
		super();
	}
	
}