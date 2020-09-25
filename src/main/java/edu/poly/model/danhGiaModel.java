package edu.poly.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class danhGiaModel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_danh_gia;
	
	@ManyToOne()
	@JoinColumn(name = "id_user")
	private userModel usermodel;
	
	@ManyToOne()
	@JoinColumn(name = "id_bai_dang")
	private baiDangModel baidangmodel;
	
	@Column(length = 20)
	private String hovaten;
	
	@Column(length = 20)
	private int so_sao;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngaylap;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngay_danh_gia;

	public int getId_danh_gia() {
		return id_danh_gia;
	}

	public void setId_danh_gia(int id_danh_gia) {
		this.id_danh_gia = id_danh_gia;
	}

	public userModel getUsermodel() {
		return usermodel;
	}

	public void setUsermodel(userModel usermodel) {
		this.usermodel = usermodel;
	}

	public baiDangModel getBaidangmodel() {
		return baidangmodel;
	}

	public void setBaidangmodel(baiDangModel baidangmodel) {
		this.baidangmodel = baidangmodel;
	}

	public String getHovaten() {
		return hovaten;
	}

	public void setHovaten(String hovaten) {
		this.hovaten = hovaten;
	}

	public int getSo_sao() {
		return so_sao;
	}

	public void setSo_sao(int so_sao) {
		this.so_sao = so_sao;
	}

	public Date getNgaylap() {
		return ngaylap;
	}

	public void setNgaylap(Date ngaylap) {
		this.ngaylap = ngaylap;
	}

	public Date getNgay_danh_gia() {
		return ngay_danh_gia;
	}

	public void setNgay_danh_gia(Date ngay_danh_gia) {
		this.ngay_danh_gia = ngay_danh_gia;
	}

	
	
	
}
