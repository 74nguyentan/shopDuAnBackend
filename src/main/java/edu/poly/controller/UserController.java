package edu.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.exception.NotFoundException;
import edu.poly.model.Users;
import edu.poly.repository.UserRepository;


@RestController
@RequestMapping("/users")
public class UserController {
	
//	@Autowired
//	private UserRepository UserRepository;
//	
//    
}
