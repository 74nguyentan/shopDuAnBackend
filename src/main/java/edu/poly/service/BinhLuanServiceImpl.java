package edu.poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.model.BinhLuan;
import edu.poly.repository.BinhLuanRepository;

@Service
public class BinhLuanServiceImpl implements BinhLuanService {

	@Autowired 
	private BinhLuanRepository binhLuanRepository;

	@Override
	public BinhLuan save(BinhLuan entity) {
		return binhLuanRepository.save(entity);
	}

	@Override
	public List<BinhLuan> saveAll(List<BinhLuan> entities) {
		return (List<BinhLuan>) binhLuanRepository.saveAll(entities);
	}

	@Override
	public Optional<BinhLuan> findById(Integer id) {
		return binhLuanRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return binhLuanRepository.existsById(id);
	}

	@Override
	public Iterable<BinhLuan> findAll() {
		return binhLuanRepository.findAll();
	}

	@Override
	public Iterable<BinhLuan> findAllById(Iterable<Integer> ids) {
		return binhLuanRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return binhLuanRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		binhLuanRepository.deleteById(id);
	}

	@Override
	public void delete(BinhLuan entity) {
		binhLuanRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends BinhLuan> entities) {
		binhLuanRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		binhLuanRepository.deleteAll();
	}
	
	
}
