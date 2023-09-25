package com.cognixia.jump.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Column(nullable = false)
	private String name;
	
	@NotBlank
	@Column(nullable = false)
	private Integer stock;
	
	@NotBlank
	@Column(nullable = false)
	private double price;
	
	@NotBlank
	@Column(nullable = false)
	private String imageUrl;
	
	@OneToMany(mappedBy = "item")
	@JsonIgnore
	private List<Orders> orders;

	public Item(Integer id, @NotBlank String name, @NotBlank Integer stock, @NotBlank double price,
			@NotBlank String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	
	public Item() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", stock=" + stock + ", price=" + price + ", imageUrl=" + imageUrl
				+ "]";
	}
	
	

}
