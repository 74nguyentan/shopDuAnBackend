package edu.poly.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.poly.model.MatHang;


@Repository
public interface MatHangRepository extends JpaRepository<MatHang, Integer> {
	//List<MatHang> findMatHangByLoaiHangId(Integer id);
//	Optional<MatHang> findByName(String tenHang);
	@Query("SELECT m FROM MatHang m WHERE m.users.id = ?1")
	List<MatHang> getAllByUsers_Id(@Param("id_user") Integer id_user, Sort sort);	
	
	@Query("SELECT m FROM MatHang m WHERE m.luotBaoCao < 1")
	List<MatHang> findAll1(Sort sort);
	
	@Query("SELECT m FROM MatHang m WHERE m.loaiHang.id = ?1 and m.luotBaoCao < 1")
	List<MatHang> findByLoaiHangId(@Param("id") Integer id, Sort sort);
	
//	List<MatHang> findFirst10ByLoaiHangId(@Param("id") Integer id, Sort sort);
//	
//	List<MatHang> findMatHangByLoaiHangId(@Param("id") Integer id);
	
//	@Query("Select m from MatHang m where m.tenHang like %:tenHang%")
//	List<MatHang> findlikename(@Param("tenHang")String tenHang);
	@Query("Select m from MatHang m where m.tenHang like %:tenHang% and m.luotBaoCao < 1")
	List<MatHang> findBytenHangContaining(@Param("tenHang")String tenHang);
	
	@Query("SELECT m FROM MatHang m WHERE m.gia <= 100000 and m.luotBaoCao < 1")
	List<MatHang> getAllgia(@Param("gia") Double gia, Sort sort);	
	
	@Query("SELECT m FROM MatHang m WHERE m.gia <= 300000 and m.gia >= 100000 and m.luotBaoCao < 1")
	List<MatHang> getgia(@Param("gia") Double gia, Sort sort);	
	
	@Query("SELECT m FROM MatHang m WHERE m.gia <= 1000000 and m.gia >= 300000 and m.luotBaoCao < 1")
	List<MatHang> getprice(@Param("gia") Double gia, Sort sort);	
	
	@Query("SELECT m FROM MatHang m WHERE m.luotBaoCao < 1 and m.ngayLap = ?1")
	List<MatHang> getAllngaylap(@Param("ngaylap") Date ngaylap);	
	
	@Query("SELECT new map(m.users.hoVaTen as hoVaTen,COUNT(m.tenHang) as soluong)"
			+ " FROM MatHang m where m.luotBaoCao < 1 GROUP BY m.users.hoVaTen ORDER BY COUNT(m.tenHang) DESC")
	Object [] getthongke();
	
	@Query("SELECT m FROM MatHang m WHERE m.luotBaoCao > 1")
	List<MatHang> findreport(Sort sort);
	
}