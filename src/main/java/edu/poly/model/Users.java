package edu.poly.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
public class Users implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50)
	private String hoVaTen;
	
	@Column(length = 50)
	private String matKhau;
	
	@Column(length = 20)
	private boolean vaiTro;
	
	@Column(length = 50)

	private String email;

	@Column(length = 12)
	private String dienThoai;
	
	@Column(length = 12)
	private String diachiuser;
	
	public String getDiachiuser() {
		return diachiuser;
	}

	public void setDiachiuser(String diachiuser) {
		this.diachiuser = diachiuser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@CreationTimestamp
	private Date ngayLap;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@UpdateTimestamp
	private Date ngaySua;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private List<BinhLuan> binhLuan;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private List<DanhGia> danhGia;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private List<MatHang> matHang;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@JsonIgnore
	public List<BinhLuan> getBinhLuan() {
		return binhLuan;
	}
	
	public void setBinhLuan(List<BinhLuan> binhLuan) {
		this.binhLuan = binhLuan;
	}
	@JsonIgnore
	public List<DanhGia> getDanhGia() {
		return danhGia;
	}
	@JsonIgnoreProperties
	public void setDanhGia(List<DanhGia> danhGia) {
		this.danhGia = danhGia;
	}
	@JsonIgnore
	public List<MatHang> getMatHang() {
		return matHang;
	}
	@JsonIgnoreProperties
	public void setMatHang(List<MatHang> matHang) {
		this.matHang = matHang;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public boolean isVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(boolean vaiTro) {
		this.vaiTro = vaiTro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public Date getNgaySua() {
		return ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		this.ngaySua = ngaySua;
	}
	
	

	

}
