package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
	
	@Query("select o from Orders o where o.user.id = ?1")
	public List<Orders> findOrdersByUser(int id);

}
