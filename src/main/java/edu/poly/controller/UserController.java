package edu.poly.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.model.Users;
import edu.poly.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/users")
	public Users createusers(@Validated @RequestBody Users users) {
		users.setNgayLap(new Date());
		return userRepository.save(users);
	}

}
