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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "LichSu")
public class LichSu implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
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
	
	@Column(length = 20)
	private boolean trangThai;

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

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
    
	

}
