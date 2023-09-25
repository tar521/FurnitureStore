package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.User;
import com.cognixia.jump.model.UserDTO;
import com.cognixia.jump.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/")
	public List<User> getAllUsers() {
		return repo.findAll();
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
		
		Optional<User> found = repo.findByUsername(username);
		
		if (found.isEmpty()) {
			return ResponseEntity.status(404).body("USER NOT FOUND");
		}
		else {
			return ResponseEntity.status(200).body(found.get());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id) {
		
		Optional<User> found = repo.findById(id);
		
		if (found.isEmpty()) {
			return ResponseEntity.status(404).body("USER NOT FOUND");
		}
		else {
			UserDTO user = new UserDTO(found.get());
			return ResponseEntity.status(200).body(user);
		}
	}

}
