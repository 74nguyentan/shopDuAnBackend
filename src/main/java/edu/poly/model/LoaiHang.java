package edu.poly.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "LoaiHang")
public class LoaiHang implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50)
	private String tenLoaiHang;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@CreationTimestamp
	private Date ngayLap;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiHang")
	private List<MatHang> matHang;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenLoaiHang() {
		return tenLoaiHang;
	}

	public void setTenLoaiHang(String tenLoaiHang) {
		this.tenLoaiHang = tenLoaiHang;
	}

	public List<MatHang> getMatHang() {
		return matHang;
	}
//	@JsonIgnore
	public void setMatHang(List<MatHang> matHang) {
		this.matHang = matHang;
	}


	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
}
