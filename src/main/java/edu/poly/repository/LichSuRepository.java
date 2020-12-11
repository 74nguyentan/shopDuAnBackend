package edu.poly.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.poly.model.BinhLuan;
import edu.poly.model.LichSu;
import edu.poly.model.MatHang;
import edu.poly.model.Users;


public interface LichSuRepository extends JpaRepository<LichSu, Integer> {

	List<LichSu> findByUsersId(@Param("id") Integer id, Sort sort);
	
//	@Transactional
//	@Modifying
//	@Query("delete from LichSu l where l.users.id = :#{#users.id}")
//	List<LichSu> deleteLichsuWithIds(@Param("users") Users users);
	@Query("SELECT l FROM LichSu l WHERE l.MatHang.id = ?1")
	List<LichSu> findmathangid(@Param("id") Integer id);
	
	@Query("select new map(l.MatHang.tenHang) FROM LichSu"
			+ " l GROUP BY l.MatHang.tenHang Having COUNT(l.MatHang.tenHang) > 2"
			+ " ORDER BY COUNT(l.MatHang.tenHang) DESC ")
	Object [] getthongkelichsu();
	
}
