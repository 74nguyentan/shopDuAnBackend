package edu.poly.services;

import java.util.List;
import java.util.Optional;



import edu.poly.model.Users;


public interface UserServices {

	void delete(Users entity);

	void deleteById(Integer id);

	long count();

	Iterable<Users> findAllById(Iterable<Integer> ids);

	Iterable<Users> findAll();

	boolean existsById(Integer id);

	Optional<Users> findById(Integer id);

	List<Users> saveAll(List<Users> entities);

	Users save(Users entity);

	Boolean checkLogin(String name, String matkhau);


}
