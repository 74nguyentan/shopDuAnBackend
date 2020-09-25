package edu.poly.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class matHangModel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_mh;
	
	@ManyToOne()
	@JoinColumn(name = "id_loai")
	private loaiHangModel loaimodel;
	
	@ManyToOne()
	@JoinColumn(name = "id_user")
	private userModel usermodel;
	
	@Column(length = 100)
	private String ten_hang;

	public Long getId_mh() {
		return id_mh;
	}

	public void setId_mh(Long id_mh) {
		this.id_mh = id_mh;
	}

	public loaiHangModel getLoaimodel() {
		return loaimodel;
	}

	public void setLoaimodel(loaiHangModel loaimodel) {
		this.loaimodel = loaimodel;
	}

	public userModel getUsermodel() {
		return usermodel;
	}

	public void setUsermodel(userModel usermodel) {
		this.usermodel = usermodel;
	}

	public String getTen_hang() {
		return ten_hang;
	}

	public void setTen_hang(String ten_hang) {
		this.ten_hang = ten_hang;
	}

	public matHangModel(Long id_mh, loaiHangModel loaimodel, userModel usermodel, String ten_hang) {
		super();
		this.id_mh = id_mh;
		this.loaimodel = loaimodel;
		this.usermodel = usermodel;
		this.ten_hang = ten_hang;
	}

	public matHangModel() {
		super();
	}

}
