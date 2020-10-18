package edu.poly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.poly.model.MatHang;

@Repository
public interface MatHangRepository extends JpaRepository<MatHang, Integer> {

}