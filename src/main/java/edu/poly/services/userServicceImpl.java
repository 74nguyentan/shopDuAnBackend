package edu.poly.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.model.Users;
import edu.poly.repository.userRepository;

@Service
public class userServicceImpl implements UserServices {
	@Autowired
	private userRepository userrepository;
	
	@Override
	public Users save(Users entity) {
		return userrepository.save(entity);
	}

	@Override
	public List<Users> saveAll(List<Users> entities) {
		return (List<Users>) userrepository.saveAll(entities);
	}

	@Override
	public Optional<Users> findById(Integer id) {
		return userrepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return userrepository.existsById(id);
	}

	@Override
	public Iterable<Users> findAll() {
		return userrepository.findAll();
	}

	@Override
	public Iterable<Users> findAllById(Iterable<Integer> ids) {
		return userrepository.findAllById(ids);
	}

	@Override
	public long count() {
		return userrepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		userrepository.deleteById(id);
	}

	@Override
	public void delete(Users entity) {
		userrepository.delete(entity);
	}

	@Override
	public Boolean checkLogin(String name, String matkhau) {
		Optional<Users> optinalUser = findById(1);
		if(optinalUser.get().getMatKhau().equals(matkhau)) {

			return true;
		}
		return false;


	}

}
