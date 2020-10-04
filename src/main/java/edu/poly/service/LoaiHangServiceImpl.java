package edu.poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.model.LoaiHang;
import edu.poly.repository.LoaiHangRepository;

@Service
public class LoaiHangServiceImpl implements LoaiHangService {
 
	@Autowired 
	private LoaiHangRepository loaihangrepository;

	@Override
	public LoaiHang save(LoaiHang entity) {
		return loaihangrepository.save(entity);
	}

	@Override
	public List<LoaiHang> saveAll(List<LoaiHang>  entities) {
		return (List<LoaiHang>) loaihangrepository.saveAll(entities);
	}

	@Override
	public Optional<LoaiHang> findById(Integer id) {
		return loaihangrepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return loaihangrepository.existsById(id);
	}

	@Override
	public List<LoaiHang>  findAll() {
		return (List<LoaiHang>) loaihangrepository.findAll();
	}

	@Override
	public Iterable<LoaiHang> findAllById(Iterable<Integer> ids) {
		return loaihangrepository.findAllById(ids);
	}

	@Override
	public long count() {
		return loaihangrepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		loaihangrepository.deleteById(id);
	}

	@Override
	public void delete(LoaiHang entity) {
		loaihangrepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends LoaiHang> entities) {
		loaihangrepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		loaihangrepository.deleteAll();
	}
	
	
}
