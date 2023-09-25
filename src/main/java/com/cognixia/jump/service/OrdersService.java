package com.cognixia.jump.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.model.Item;
import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.ItemRepository;
import com.cognixia.jump.repository.UserRepository;

@Service
public class OrdersService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ItemRepository itemRepo;
	
	public Optional<User> getUserByUsername(String username) {
		 Optional<User> found = userRepo.findByUsername(username);
		 
		 if (found.isEmpty()) {
			 return null;
		 } else {
			 return found;
		 }
	}
	
	public Optional<Item> getItemById(int id) {
		Optional<Item> found = itemRepo.findById(id);
		
		if (found.isEmpty()) {
			 return null;
		 } else {
			 return found;
		 }
	}

}
