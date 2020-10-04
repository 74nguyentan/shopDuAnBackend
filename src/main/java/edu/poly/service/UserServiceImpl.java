package edu.poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.model.Users;
import edu.poly.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository usersrepository;

	@Override
	public Users save(Users entity) {
		return usersrepository.save(entity);
	}

//	@Override
//	public List<Users> findUserByName(String hoVaTen) {
//		return usersrepository.findUserByName(hoVaTen);
//	}

	@Override
	public List<Users> saveAll(List<Users> entities) {
		return (List<Users>) usersrepository.saveAll(entities);
	}

	@Override
	public Optional<Users> findById(Integer id) {
		return usersrepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return usersrepository.existsById(id);
	}

	@Override
	public List<Users> findAll() {
		return (List<Users>) usersrepository.findAll();
	}

	@Override
	public Iterable<Users> findAllById(Iterable<Integer> ids) {
		return usersrepository.findAllById(ids);
	}

	@Override
	public long count() {
		return usersrepository.count();
	}

	@Override
	public Users deleteById(Integer id) {
		usersrepository.deleteById(id);
		return null;
	}

	@Override
	public void delete(Users entity) {
		usersrepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Users> entities) {
		usersrepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		usersrepository.deleteAll();
	}
	
}
