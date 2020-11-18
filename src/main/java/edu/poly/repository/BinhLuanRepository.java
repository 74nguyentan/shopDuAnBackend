package edu.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.poly.model.BinhLuan;
import edu.poly.model.MatHang;

public interface BinhLuanRepository extends JpaRepository<BinhLuan, Integer>{
	@Query("SELECT b FROM BinhLuan b WHERE b.MatHang.id = ?1")
	List<BinhLuan> getAllByMatHang_Id(Integer id_mathang);
	List<BinhLuan> findByUsersId(@Param("id") Integer id);
}
