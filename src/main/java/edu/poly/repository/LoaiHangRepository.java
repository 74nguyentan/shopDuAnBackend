package edu.poly.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.model.LoaiHang;

@Repository
public interface LoaiHangRepository extends CrudRepository<LoaiHang, Integer> {

}
