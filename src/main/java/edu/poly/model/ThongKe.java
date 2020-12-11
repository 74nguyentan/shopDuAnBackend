package edu.poly.model;

import java.io.Serializable;


public class ThongKe {
	
	private String hoVaTen;
	private Long soluong;
	public ThongKe(String hoVaTen, Long soluong) {
		this.hoVaTen = hoVaTen;
		this.soluong = soluong;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public Long getSoluong() {
		return soluong;
	}
	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}
	
	
}
