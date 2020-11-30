package edu.poly.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "productFavou")
public class productFavourite implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length=20)
	private Boolean yeuThich;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@CreationTimestamp
	private Date ngayLap;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MatHang_id")
    private MatHang MatHang;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Users_id")
    private Users users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public MatHang getMatHang() {
		return MatHang;
	}

	public void setMatHang(MatHang matHang) {
		MatHang = matHang;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	

	public Boolean getYeuThich() {
		return yeuThich;
	}

	public void setYeuThich(Boolean yeuThich) {
		this.yeuThich = yeuThich;
	}

	public productFavourite() {
		super();
	}

	public productFavourite(int id, Date ngayLap, edu.poly.model.MatHang matHang, Users users) {
		super();
		this.id = id;
		this.ngayLap = ngayLap;
		MatHang = matHang;
		this.users = users;
	}
    
	
}
