package com.cognixia.jump.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Item;
import com.cognixia.jump.model.Orders;
import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.OrdersRepository;
import com.cognixia.jump.service.OrdersService;

@RestController
@RequestMapping("/order")
public class OrdersController {
	
	@Autowired
	private OrdersRepository repo;
	
	@Autowired
	private OrdersService service;
	
	@GetMapping("/orders")
	public List<Orders> getAllOrders() {
		return repo.findAll();
	}
	
	@GetMapping("/userorders")
	public List<Orders> getAllUserOrders() {
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		
		Optional<User> userFound = service.getUserByUsername(username);
		
		if (userFound == null || userFound.isEmpty()) {
			return null;
		}
		
		List<Orders> userOrders = repo.findOrdersByUser(userFound.get().getId().intValue());
		
		if (userOrders == null) {
			return null; // ERROR: error querying
		}
		
		if (userOrders.isEmpty()) {
			return null; // no orders found
		}
		
		return userOrders; // return the list
	}
	
	@PostMapping("/{id}/{quantity}")
	public ResponseEntity<?> placeOrder(@PathVariable int id, @PathVariable int quantity) {
		
		if (quantity < 1) {
			return null; // invalid order
		}
		
		Optional<Item> itemFound = service.getItemById(id);
		
		if (itemFound == null || itemFound.isEmpty()) {
			return null;
		}
		if (itemFound.get().getStock().intValue() == 0 || itemFound.get().getStock().intValue() < quantity) {
			return null;
		}
		
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		
		Optional<User> userFound = service.getUserByUsername(username);
		
		if (userFound == null || userFound.isEmpty()) {
			return null;
		}
		
		Orders saved = new Orders(null, itemFound.get().getPrice() * quantity, LocalDateTime.now());
		saved.setItem(itemFound.get());
		saved.setUser(userFound.get());
		
		saved = repo.save(saved);
		
		return ResponseEntity.status(201).body(saved);
		
	}
	

}
