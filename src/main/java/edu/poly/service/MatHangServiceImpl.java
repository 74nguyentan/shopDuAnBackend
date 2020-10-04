package edu.poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.model.MatHang;
import edu.poly.repository.MatHangRepository;

@Service
public class MatHangServiceImpl implements MatHangService {

	@Autowired
	private MatHangRepository mathangrepository;

	@Override
	public  MatHang save(MatHang entity) {
		return mathangrepository.save(entity);
	}

	@Override
	public List<MatHang> saveAll(List<MatHang> entities) {
		return (List<MatHang>) mathangrepository.saveAll(entities);
	}
	
	@Override
	public List<MatHang>findBytenHangLike(String tenhang){
	return mathangrepository.findBytenHangContaining(tenhang);
	}


	@Override
	public Optional<MatHang> findById(Integer id) {
		return mathangrepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return mathangrepository.existsById(id);
	}

	@Override
	public List<MatHang> findAll() {
		return (List<MatHang>) mathangrepository.findAll();
	}

	@Override
	public Iterable<MatHang> findAllById(Iterable<Integer> ids) {
		return mathangrepository.findAllById(ids);
	}

	@Override
	public long count() {
		return mathangrepository.count();
	}

	@Override
	public MatHang deleteById(Integer id) {
		mathangrepository.deleteById(id);
		return null;
	}

	@Override
	public void delete(MatHang entity) {
		mathangrepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends MatHang> entities) {
		mathangrepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		mathangrepository.deleteAll();
	}

	
	
	
}
