package edu.poly.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "UserModels")
public class Users {
	private int id;
	private String hoVaTen;
	private String hinhAnhUser;
	private String matKhau;
	private boolean vaiTro;
	private String email;
	private String dienThoai;
	private String diaChiUser;
	private Date ngayLap;

	public Users() {
		super();
	}

	public Users(int id, String hoVaTen, String hinhAnhUser, String matKhau, boolean vaiTro, String email,
			String dienThoai, String diaChiUser, Date ngayLap) {
		super();
		this.id = id;
		this.hoVaTen = hoVaTen;
		this.hinhAnhUser = hinhAnhUser;
		this.matKhau = matKhau;
		this.vaiTro = vaiTro;
		this.email = email;
		this.dienThoai = dienThoai;
		this.diaChiUser = diaChiUser;
		this.ngayLap = ngayLap;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "hoVaTen", nullable = false)
	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	@Column(name = "hinhAnhUser")
	public String getHinhAnhUser() {
		return hinhAnhUser;
	}

	public void setHinhAnhUser(String hinhAnhUser) {
		this.hinhAnhUser = hinhAnhUser;
	}

	@Column(name = "matKhau", nullable = false)
	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@Column(name = "vaiTro", nullable = false)
	public boolean isVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(boolean vaiTro) {
		this.vaiTro = vaiTro;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "dienThoai", nullable = false)
	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	@Column(name = "diaChiUser", nullable = false)
	public String getDiaChiUser() {
		return diaChiUser;
	}

	public void setDiaChiUser(String diaChiUser) {
		this.diaChiUser = diaChiUser;
	}

	@Column(name = "ngayLap") 
	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	@Override
	public String toString() {
		return "UseTestModel [id = " + id + " , hoVaTen = " + hoVaTen + " ,hinhAnhUser = " + hinhAnhUser + " , matKhau = "
				+ matKhau + ",vaiTro = " + vaiTro + ", email = " + email + ",dienThoai = " + dienThoai
				+ ",diaChiUser = " + diaChiUser + ",ngayLap = " + ngayLap + " ]";
	}
}