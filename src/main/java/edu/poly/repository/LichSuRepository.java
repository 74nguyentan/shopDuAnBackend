package edu.poly.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.poly.model.BinhLuan;
import edu.poly.model.LichSu;


public interface LichSuRepository extends JpaRepository<LichSu, Integer> {

	List<LichSu> findByUsersId(@Param("id") Integer id);
	
	@Modifying
	@Query("delete from LichSu l where l.users = ?1")
	List<LichSu> deleteLichsuWithIds(@Param("Users_id") LichSu lichsu);
}
