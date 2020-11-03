package edu.poly.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.poly.model.MatHang;

@Repository
public interface MatHangRepository extends JpaRepository<MatHang, Integer> {
	//List<MatHang> findMatHangByLoaiHangId(Integer id);
//	Optional<MatHang> findByName(String tenHang);
	List<MatHang> findByLoaiHangId(@Param("id") Integer id);
}