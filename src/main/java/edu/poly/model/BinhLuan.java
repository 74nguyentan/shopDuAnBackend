package edu.poly.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "BinhLuan")
public class BinhLuan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String noiDungBinhLuan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Users_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Users users;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MatHang_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private MatHang MatHang;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @CreationTimestamp
    private Date ngayLap;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNoiDungBinhLuan() {
		return noiDungBinhLuan;
	}

	public void setNoiDungBinhLuan(String noiDungBinhLuan) {
		this.noiDungBinhLuan = noiDungBinhLuan;
	}

	public Users getUsers() {
		return users;
	}
	@JsonIgnore
	public void setUsers(Users users) {
		this.users = users;
	}

	public MatHang getMatHang() {
		return MatHang;
	}
	@JsonIgnore
	public void setMatHang(MatHang matHang) {
		MatHang = matHang;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}


	
   
}
