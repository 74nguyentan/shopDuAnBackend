package edu.poly.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "NhanTin")
public class NhanTin implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 500)
	private String noiDungNhanTin;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "from_user_id")
	private Users fromUser;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "to_user_id")
	private Users toUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@CreationTimestamp
	private Date ngayLap;
	
	private boolean isUserRead;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNoiDungNhanTin() {
		return noiDungNhanTin;
	}

	public void setNoiDungNhanTin(String noiDungNhanTin) {
		this.noiDungNhanTin = noiDungNhanTin;
	}

	public Users getFromUser() {
		return fromUser;
	}

	public void setFromUser(Users fromUser) {
		this.fromUser = fromUser;
	}

	public Users getToUser() {
		return toUser;
	}

	public void setToUser(Users toUser) {
		this.toUser = toUser;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public boolean isUserRead() {
		return isUserRead;
	}

	public void setUserRead(boolean isUserRead) {
		this.isUserRead = isUserRead;
	}
	
	

}
