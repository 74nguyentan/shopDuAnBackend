package edu.poly.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "MatHang")
public class MatHang implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 50)
	private String tenHang;
	
	@Column(length = 50)
	private double gia;
	
	@Column(length = 50)
	private String xuatXu;
	
	@Column(length = 150)
	private String hinh0;
	
	@Column(length = 150)
	private String hinh1;
	
	@Column(length = 150)
	private String hinh2;
	
	@Column(length = 150)
	private String hinh3;
	
	@Column(length = 1000)
	private String moTa;
	
	@Column(length = 100)
	private int soLuong;
	
	@Column(length = 100)
	private int diaChiBan;
	
	@Column(length = 20)
	private boolean trangThai;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@CreationTimestamp
	private Date ngayLap;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@UpdateTimestamp
	private Date ngaySua;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LoaiHang_id")
	private LoaiHang loaiHang;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Users_id")
	private Users users;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "MatHang")
	private List<BinhLuan> binhLuan;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "MatHang")
	private List<DanhGia> danhGia;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getXuatXu() {
		return xuatXu;
	}

	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}


	public String getHinh0() {
		return hinh0;
	}

	public void setHinh0(String hinh0) {
		this.hinh0 = hinh0;
	}

	public String getHinh1() {
		return hinh1;
	}

	public void setHinh1(String hinh1) {
		this.hinh1 = hinh1;
	}

	public String getHinh2() {
		return hinh2;
	}

	public void setHinh2(String hinh2) {
		this.hinh2 = hinh2;
	}

	public String getHinh3() {
		return hinh3;
	}

	public void setHinh3(String hinh3) {
		this.hinh3 = hinh3;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getDiaChiBan() {
		return diaChiBan;
	}

	public void setDiaChiBan(int diaChiBan) {
		this.diaChiBan = diaChiBan;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<BinhLuan> getBinhLuan() {
		return binhLuan;
	}

	public void setBinhLuan(List<BinhLuan> binhLuan) {
		this.binhLuan = binhLuan;
	}

	public List<DanhGia> getDanhGia() {
		return danhGia;
	}

	public void setDanhGia(List<DanhGia> danhGia) {
		this.danhGia = danhGia;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
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

	public LoaiHang getLoaiHang() {
		return loaiHang;
	}

	public void setLoaiHang(LoaiHang loaiHang) {
		this.loaiHang = loaiHang;
	}
}
