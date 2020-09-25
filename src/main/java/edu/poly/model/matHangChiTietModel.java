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
public class matHangChiTietModel implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_mh_ct;
	
	@ManyToOne()
	@JoinColumn(name = "id_hang")
	private matHangModel mathangmodel;
	
	@Column(length = 50)
	private String ten_hang;
	
	@Column(length = 50)
	private double gia;
	
	@Column(length = 50)
	private String xuat_xu;
	
	@Column(length = 50)
	private String hinh;
	
	@Column(length = 50)
	private String mo_ta;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngaylap;

	public int getId_mh_ct() {
		return id_mh_ct;
	}

	public void setId_mh_ct(int id_mh_ct) {
		this.id_mh_ct = id_mh_ct;
	}

	public matHangModel getMathangmodel() {
		return mathangmodel;
	}

	public void setMathangmodel(matHangModel mathangmodel) {
		this.mathangmodel = mathangmodel;
	}

	public String getTen_hang() {
		return ten_hang;
	}

	public void setTen_hang(String ten_hang) {
		this.ten_hang = ten_hang;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getXuat_xu() {
		return xuat_xu;
	}

	public void setXuat_xu(String xuat_xu) {
		this.xuat_xu = xuat_xu;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public String getMo_ta() {
		return mo_ta;
	}

	public void setMo_ta(String mo_ta) {
		this.mo_ta = mo_ta;
	}

	public Date getNgaylap() {
		return ngaylap;
	}

	public void setNgaylap(Date ngaylap) {
		this.ngaylap = ngaylap;
	}

	public matHangChiTietModel() {
		super();
	}

	public matHangChiTietModel(int id_mh_ct, matHangModel mathangmodel, String ten_hang, double gia, String xuat_xu,
			String hinh, String mo_ta, Date ngaylap) {
		super();
		this.id_mh_ct = id_mh_ct;
		this.mathangmodel = mathangmodel;
		this.ten_hang = ten_hang;
		this.gia = gia;
		this.xuat_xu = xuat_xu;
		this.hinh = hinh;
		this.mo_ta = mo_ta;
		this.ngaylap = ngaylap;
	}
	
	
}
