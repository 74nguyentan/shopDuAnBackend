package edu.poly.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.model.MatHang;

@Repository
public interface MatHangRepository extends CrudRepository<MatHang, Integer> {

	List<MatHang> findBytenHangContaining (String tenhang);
}