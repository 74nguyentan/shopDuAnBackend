package edu.poly.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import edu.poly.model.BinhLuan;
import edu.poly.model.MatHang;
import edu.poly.model.ThongKe;

@Repository
public interface MatHangRepository extends JpaRepository<MatHang, Integer> {
	//List<MatHang> findMatHangByLoaiHangId(Integer id);
//	Optional<MatHang> findByName(String tenHang);
	@Query("SELECT m FROM MatHang m WHERE m.users.id = ?1")
	List<MatHang> getAllByUsers_Id(@Param("id_user") Integer id_user, Sort sort);		
	List<MatHang> findByLoaiHangId(@Param("id") Integer id, Sort sort);
	
	List<MatHang> findFirst10ByLoaiHangId(@Param("id") Integer id, Sort sort);
	
	List<MatHang> findMatHangByLoaiHangId(@Param("id") Integer id);
	
//	@Query("Select m from MatHang m where m.tenHang like %:tenHang%")
//	List<MatHang> findlikename(@Param("tenHang")String tenHang);
	List<MatHang> findBytenHangContaining(@Param("tenHang")String tenHang);
	
	@Query("SELECT m FROM MatHang m WHERE m.gia <= ?1 ")
	List<MatHang> getAllgia(@Param("gia") Double gia, Sort sort);	
	
	@Query("SELECT m FROM MatHang m WHERE m.gia <= 300000 and m.gia >= 100000 ")
	List<MatHang> getgia(@Param("gia") Double gia, Sort sort);	
	
	@Query("SELECT m FROM MatHang m WHERE m.gia <= 1000000 and m.gia >= 300000 ")
	List<MatHang> getprice(@Param("gia") Double gia, Sort sort);	
	
	@Query("SELECT m FROM MatHang m WHERE m.ngayLap = ?1 ")
	List<MatHang> getAllngaylap(@Param("ngaylap") Date ngaylap);	
	
	@Query("SELECT new map(m.users.hoVaTen as hoVaTen,COUNT(m.tenHang) as soluong)"
			+ " FROM MatHang m GROUP BY m.users.hoVaTen ORDER BY COUNT(m.tenHang) DESC")
	Object [] getthongke();
	
}