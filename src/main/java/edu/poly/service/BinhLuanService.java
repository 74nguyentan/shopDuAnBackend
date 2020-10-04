package edu.poly.service;

import java.util.List;
import java.util.Optional;

import edu.poly.model.BinhLuan;

public interface BinhLuanService {

	void deleteAll();

	void deleteAll(Iterable<? extends BinhLuan> entities);

	void delete(BinhLuan entity);

	void deleteById(Integer id);

	long count();

	Iterable<BinhLuan> findAllById(Iterable<Integer> ids);

	Iterable<BinhLuan> findAll();

	boolean existsById(Integer id);

	Optional<BinhLuan> findById(Integer id);

	List<BinhLuan> saveAll(List<BinhLuan> entities);

	BinhLuan save(BinhLuan entity);

	
	
}
