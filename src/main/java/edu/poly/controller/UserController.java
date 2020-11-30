package edu.poly.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import edu.poly.model.Users;
import edu.poly.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	// create user
	@PostMapping("/users") 
	public Users createusers(@Validated @RequestBody Users users) {
		users.setNgayLap(new Date());
		users.setHinhAnhUser("https://drive.google.com/uc?export=download&id=1iS9kCSq3r0jnGvyNGicWp_WJOqH5kpEN");
		return userRepository.save(users);
	}

	// tìm theo id
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
		Users user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		return ResponseEntity.ok().body(user);
	}

	// tìm theo email, dùng để hiển thị và update thông tin người dùng
	@GetMapping("users/email/{email}")
	public List<Users> getUserByEmail(@PathVariable("email") String email) {
		return userRepository.findByEmail(email);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<Users> updateUsers(@PathVariable("id") Integer id, @Validated @RequestBody Users users)
			throws ResourceNotFoundException {
		Users user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id user not found"));
		user.setHoVaTen(users.getHoVaTen());
		user.setHinhAnhUser(users.getHinhAnhUser());
		user.setMatKhau(users.getMatKhau());
		user.setDiaChiUser(users.getDiaChiUser());
		user.setDienThoai(users.getDienThoai());
		user.setEmail(users.getEmail());
		final Users updateUser = userRepository.save(user);
		return ResponseEntity.ok(updateUser);
	}
}
