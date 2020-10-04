package edu.poly.service;

import java.util.List;
import java.util.Optional;

import edu.poly.model.MatHang;

public interface MatHangService {

	void deleteAll();

	void deleteAll(Iterable<? extends MatHang> entities);

	void delete(MatHang entity);

	MatHang deleteById(Integer id);

	long count();

	Iterable<MatHang> findAllById(Iterable<Integer> ids);

	List<MatHang> findAll();

	boolean existsById(Integer id);

	Optional<MatHang> findById(Integer id);

	List<MatHang> saveAll(List<MatHang> entities);

	MatHang save(MatHang entity);

	List<MatHang> findBytenHangLike(String tenhang);


}
