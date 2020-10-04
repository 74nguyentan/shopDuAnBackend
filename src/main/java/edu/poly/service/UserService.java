package edu.poly.service;

import java.util.List;
import java.util.Optional;

import edu.poly.model.Users;

public interface UserService {

	void deleteAll();

	void deleteAll(Iterable<? extends Users> entities);

	void delete(Users entity);

	Users deleteById(Integer id);

	long count();

	Iterable<Users> findAllById(Iterable<Integer> ids);

	List<Users> findAll();

	boolean existsById(Integer id);

	Optional<Users> findById(Integer id);

	List<Users> saveAll(List<Users> entities);

	Users save(Users entity);

}
