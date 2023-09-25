package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Item;
import com.cognixia.jump.repository.ItemRepository;

@RestController
@RequestMapping("/item")
public class FurnitureController {
	
	@Autowired
	private ItemRepository itemRepo;
	
	@GetMapping("/")
	public List<Item> getAllItems() {
		return itemRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getItemById(@PathVariable int id) {
		Optional<Item> found = itemRepo.findById(id);
		
		if (found.isEmpty()) {
			return ResponseEntity.status(404).body("ITEM NOT FOUND");
		}
		else {
			return ResponseEntity.status(200).body(found.get());
		}
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<?> getItemByName(@PathVariable String name) {
		Optional<Item> found = itemRepo.findByName(name);
		
		if (found.isEmpty()) {
			return ResponseEntity.status(404).body("ITEM NOT FOUND");
		}
		else {
			return ResponseEntity.status(200).body(found.get());
		}
	}
	
	//TODO
	// ADMIN ENDPOINTS TO EDIT ITEMS

}
