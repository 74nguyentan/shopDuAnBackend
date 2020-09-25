package edu.poly.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class loaiHangModel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_danh_gia;
	
	@Column(length = 50)
	private String tenloaihang;

	public int getId_danh_gia() {
		return id_danh_gia;
	}

	public void setId_danh_gia(int id_danh_gia) {
		this.id_danh_gia = id_danh_gia;
	}

	public String getTenloaihang() {
		return tenloaihang;
	}

	public void setTenloaihang(String tenloaihang) {
		this.tenloaihang = tenloaihang;
	}

	public loaiHangModel(int id_danh_gia, String tenloaihang) {
		super();
		this.id_danh_gia = id_danh_gia;
		this.tenloaihang = tenloaihang;
	}

	public loaiHangModel() {
		super();
	}
	
}
