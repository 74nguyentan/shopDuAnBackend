package edu.poly.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "UserModels")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 150)
	private String hoVaTen;

	@Column(length = 300)
	private String hinhAnhUser;

	@Column(length = 150)
	private String matKhau;

	@Column(length = 150)
	private String xacNhanMatKhau;

	@Column(length = 20)
	private boolean vaiTro;

	@Column(length = 100)

	private String email;

	@Column(length = 12)
	private String dienThoai;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@CreationTimestamp
	private Date ngayLap;

	@Column(length = 200)
	private String diaChiUser;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private List<BinhLuan> binhLuan;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private List<DanhGia> danhGia;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private List<MatHang> matHang;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private List<LichSu> lichSu;
	
	 @OneToMany(mappedBy = "toUser",
	            cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	    @Fetch(value = FetchMode.SUBSELECT)
	 @JsonIgnore
	 private List<NhanTin> nhanTin;

	public Users() {
		super();
	}

	public Users(int id, String hoVaTen, String hinhAnhUser, String matKhau, String xacNhanMatKhau, boolean vaiTro,
			String email, String dienThoai, Date ngayLap, String diaChiUser, List<BinhLuan> binhLuan,
			List<DanhGia> danhGia, List<MatHang> matHang) {
		super();
		this.id = id;
		this.hoVaTen = hoVaTen;
		this.hinhAnhUser = hinhAnhUser;
		this.matKhau = matKhau;
		this.xacNhanMatKhau = xacNhanMatKhau;
		this.vaiTro = vaiTro;
		this.email = email;
		this.dienThoai = dienThoai;
		this.ngayLap = ngayLap;
		this.diaChiUser = diaChiUser;
		this.binhLuan = binhLuan;
		this.danhGia = danhGia;
		this.matHang = matHang;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getXacNhanMatKhau() {
		return xacNhanMatKhau;
	}

	public void setXacNhanMatKhau(String xacNhanMatKhau) {
		this.xacNhanMatKhau = xacNhanMatKhau;
	}

	public String getHinhAnhUser() {
		return hinhAnhUser;
	}

	public void setHinhAnhUser(String hinhAnhUser) {
		this.hinhAnhUser = hinhAnhUser;
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

	public String getDiaChiUser() {
		return diaChiUser;
	}

	public void setDiaChiUser(String diaChiUser) {

		this.diaChiUser = diaChiUser;
	}
}