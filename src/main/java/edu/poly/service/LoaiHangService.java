package edu.poly.service;

import java.util.List;
import java.util.Optional;

import edu.poly.model.LoaiHang;

public interface LoaiHangService {

	void deleteAll();

	void deleteAll(Iterable<? extends LoaiHang> entities);

	void delete(LoaiHang entity);

	void deleteById(Integer id);

	long count();

	Iterable<LoaiHang> findAllById(Iterable<Integer> ids);

	List<LoaiHang> findAll();

	boolean existsById(Integer id);

	Optional<LoaiHang> findById(Integer id);

	List<LoaiHang> saveAll(List<LoaiHang>  entities);

	LoaiHang save(LoaiHang entity);

}
