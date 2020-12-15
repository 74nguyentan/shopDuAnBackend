package edu.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.poly.model.BinhLuan;
import edu.poly.model.MatHang;

@Repository
public interface BinhLuanRepository extends JpaRepository<BinhLuan, Integer>{
	@Query("SELECT b FROM BinhLuan b WHERE b.MatHang.id = ?1")
	List<BinhLuan> getAllByMatHang_Id(@Param("id") Integer id);	
	List<BinhLuan> findByUsersId(@Param("id") Integer id);
}
