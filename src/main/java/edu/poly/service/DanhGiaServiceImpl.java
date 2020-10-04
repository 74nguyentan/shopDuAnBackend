package edu.poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.model.DanhGia;
import edu.poly.repository.DanhGiaRepository;

@Service
public class DanhGiaServiceImpl implements DanhGiaService{

	@Autowired
	private DanhGiaRepository danhgiarepository;

	@Override
	public DanhGia save(DanhGia entity) {
		return danhgiarepository.save(entity);
	}

	@Override
	public List<DanhGia> saveAll(List<DanhGia> entities) {
		return (List<DanhGia>) danhgiarepository.saveAll(entities);
	}

	@Override
	public Optional<DanhGia> findById(Integer id) {
		return danhgiarepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return danhgiarepository.existsById(id);
	}

	@Override
	public Iterable<DanhGia> findAll() {
		return danhgiarepository.findAll();
	}

	@Override
	public Iterable<DanhGia> findAllById(Iterable<Integer> ids) {
		return danhgiarepository.findAllById(ids);
	}

	@Override
	public long count() {
		return danhgiarepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		danhgiarepository.deleteById(id);
	}

	@Override
	public void delete(DanhGia entity) {
		danhgiarepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends DanhGia> entities) {
		danhgiarepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		danhgiarepository.deleteAll();
	}
	
	
}
