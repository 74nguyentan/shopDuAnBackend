package edu.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.exception.UserNotFoundException;
import edu.poly.model.Users;
import edu.poly.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	// hiển thị user theo id
	@GetMapping("/get/{id}")
	public Users get(@PathVariable Integer id) {
		Users users = userservice.findById(id).orElseThrow(()->new UserNotFoundException());
		return users;
	}
    
	//Save user
	@PostMapping("save")
	public Users save(@RequestBody Users users) {
		return userservice.save(users);
	}
	
	//hiển thị tất cả user
	@GetMapping("list")
	public List<Users> listAll(){
		return (List<Users>) userservice.findAll();
	}
	
//	cập nhật user theo id
	@PutMapping("update/{id}")
	public Users update(@PathVariable Integer id, @RequestBody Users users) {
		return userservice.findById(id)
				.map(use ->{
					use.setDienThoai(users.getDienThoai());
					use.setHoVaTen(users.getHoVaTen());
					use.setEmail(users.getEmail());
					use.setMatKhau(users.getMatKhau());
					use.setVaiTro(users.isVaiTro());
					use.setNgayLap(users.getNgayLap());
					use.setHinhAnhUser(users.getHinhAnhUser());
					use.setDiaChiUser(users.getDiaChiUser());
					return userservice.save(use);
				}).get();
	}
	
	@DeleteMapping("delete/{id}")
	public Users delete(@PathVariable Integer id) {
		return userservice.deleteById(id);
	}
//	@GetMapping("/find/{hoVaTen}")
//	public List<Users> findByName(String hoVaTen){
//		return userservice.findUserByName(hoVaTen);
//	}
    
}
