package edu.poly.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import edu.poly.model.Users;
import edu.poly.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired 
	private UserRepository userrepository;
	
    
    public UserController(UserRepository userrepository) {
        this.userrepository = userrepository;
    }
    
//    @GetMapping("/users")
//    public Collection<Users> coolCars() {
//        return userrepository.findAll();
//    }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<Users>> listAllUsers(){
		List<Users> users= userrepository.findAll();
		if(users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
	}
     
    
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Users users) {
        userrepository.save(users);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> save(@PathVariable Integer id) {
        userrepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        Users users = userrepository.getOne(id);
        return new ResponseEntity<Users>(users, HttpStatus.OK);
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Users> users = userrepository.findAll();
        List<Integer> listId = new ArrayList<>();
        for (Users item : users) {
        	listId.add(item.getId());
		}
        return new ResponseEntity<>(listId, HttpStatus.OK);
    }
    
}
