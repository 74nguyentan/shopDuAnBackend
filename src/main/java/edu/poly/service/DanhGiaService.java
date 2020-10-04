package edu.poly.service;

import java.util.List;
import java.util.Optional;

import edu.poly.model.DanhGia;

public interface DanhGiaService {

	void deleteAll();

	void deleteAll(Iterable<? extends DanhGia> entities);

	void delete(DanhGia entity);

	void deleteById(Integer id);

	long count();

	Iterable<DanhGia> findAllById(Iterable<Integer> ids);

	Iterable<DanhGia> findAll();

	boolean existsById(Integer id);

	Optional<DanhGia> findById(Integer id);

	List<DanhGia> saveAll(List<DanhGia> entities);

	DanhGia save(DanhGia entity);

}
