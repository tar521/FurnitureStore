package com.cognixia.jump.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	public Optional<Item> findByName(String username);

}
