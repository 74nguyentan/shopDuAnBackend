package edu.poly.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "MatHang")
public class MatHang implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 100)
	private String tenHang;
	
	@Column(length = 50)
	private double gia;
	
	@Column(length = 100)
	private Integer luotBaoCao;
	
	@Column(length = 50)
	private String xuatXu;
	
	@Column(length = 65535)
	private String hinh0;
	
	@Column(length = 65535)
	private String hinh1;
	
	@Column(length = 65535)
	private String hinh2;
	
	@Column(length = 65535)
	private String hinh3;
	
	@Column(length = 65535)
	private String moTa;
	
	@Column(length = 100)
	private Date thoiHan;
	
	@Column(length = 200)
	private String diaChiBan;
	
	@Column(length = 12)
	private String dienThoai;
	
	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	@Column(length = 20)
	private boolean trangThai;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@CreationTimestamp
	private Date ngayLap;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Id_loaiHang")
	private LoaiHang loaiHang;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Users_id")
	private Users users;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "MatHang", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BinhLuan> binhLuan;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "MatHang", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LichSu> lichSu;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "MatHang", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<productFavourite> productFavourite;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "MatHang")
	private List<DanhGia> danhGia;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public LoaiHang getLoaiHang() {
		return loaiHang;
	}

	public void setLoaiHang(LoaiHang loaiHang) {
		this.loaiHang = loaiHang;
	}
	@JsonIgnoreProperties({"hibernateLazyInitializer"})
	public Users getUsers() {
		return users;
	}
	
	public void setUsers(Users users) {
		this.users = users;
	}
	
	@JsonIgnoreProperties({"hibernateLazyInitializer"})
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

	public void setDanhGia(List<DanhGia> danhGia) {
		this.danhGia = danhGia;
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

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Date getThoiHan() {
		return thoiHan;
	}

	public void setThoiHan(Date thoiHan) {
		this.thoiHan = thoiHan;
	}

	public String getDiaChiBan() {
		return diaChiBan;
	}

	public void setDiaChiBan(String diaChiBan) {
		this.diaChiBan = diaChiBan;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public MatHang(int id, String tenHang, double gia, String xuatXu, String hinh0, String hinh1, String hinh2,
			String hinh3, String moTa, Date thoiHan, String diaChiBan, String dienThoai, boolean trangThai,
			Date ngayLap, LoaiHang loaiHang, Users users, List<BinhLuan> binhLuan, List<DanhGia> danhGia) {
		super();
		this.id = id;
		this.tenHang = tenHang;
		this.gia = gia;
		this.xuatXu = xuatXu;
		this.hinh0 = hinh0;
		this.hinh1 = hinh1;
		this.hinh2 = hinh2;
		this.hinh3 = hinh3;
		this.moTa = moTa;
		this.thoiHan = thoiHan;
		this.diaChiBan = diaChiBan;
		this.dienThoai = dienThoai;
		this.trangThai = trangThai;
		this.ngayLap = ngayLap;
		this.loaiHang = loaiHang;
		this.users = users;
		this.binhLuan = binhLuan;
		this.danhGia = danhGia;
	}

	public MatHang() {
		super();
	}
	public Integer getLuotBaoCao() {
		return luotBaoCao;
	}

	public void setLuotBaoCao(Integer luotBaoCao) {
		this.luotBaoCao = luotBaoCao;
	}
	
	

}