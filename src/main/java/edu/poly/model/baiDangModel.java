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
@Table(name = "baidang")
public class baiDangModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_bai_dang;
	
	@ManyToOne()
	@JoinColumn(name = "id_loai")
	private loaiHangModel loaimodel;
	
	@ManyToOne()
	@JoinColumn(name = "id_hang")
	private matHangModel mathangmodel;
	
	@Column(length = 100)
	private String no_dung;
	
	@Column(length = 100)
	private int phan_hoi;

	public int getId_bai_dang() {
		return id_bai_dang;
	}

	public void setId_bai_dang(int id_bai_dang) {
		this.id_bai_dang = id_bai_dang;
	}

	public loaiHangModel getLoaimodel() {
		return loaimodel;
	}

	public void setLoaimodel(loaiHangModel loaimodel) {
		this.loaimodel = loaimodel;
	}

	public matHangModel getMathangmodel() {
		return mathangmodel;
	}

	public void setMathangmodel(matHangModel mathangmodel) {
		this.mathangmodel = mathangmodel;
	}

	public String getNo_dung() {
		return no_dung;
	}

	public void setNo_dung(String no_dung) {
		this.no_dung = no_dung;
	}

	public int getPhan_hoi() {
		return phan_hoi;
	}

	public void setPhan_hoi(int phan_hoi) {
		this.phan_hoi = phan_hoi;
	}

	public baiDangModel(int id_bai_dang, loaiHangModel loaimodel, matHangModel mathangmodel, String no_dung,
			int phan_hoi) {
		super();
		this.id_bai_dang = id_bai_dang;
		this.loaimodel = loaimodel;
		this.mathangmodel = mathangmodel;
		this.no_dung = no_dung;
		this.phan_hoi = phan_hoi;
	}

	public baiDangModel() {
		super();
	}

	
}
