package edu.poly.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "binhluan")
public class binhLuanModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_danh_gia;
	
	@ManyToOne()
	@JoinColumn(name = "id_user")
	private userModel usermodel;
	
	@ManyToOne()
	@JoinColumn(name = "id_bai_dang")
	private baiDangModel baidangmodel;

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

	public binhLuanModel(int id_danh_gia, userModel usermodel, baiDangModel baidangmodel) {
		super();
		this.id_danh_gia = id_danh_gia;
		this.usermodel = usermodel;
		this.baidangmodel = baidangmodel;
	}

	public binhLuanModel() {
		super();
	}
	
	
}
