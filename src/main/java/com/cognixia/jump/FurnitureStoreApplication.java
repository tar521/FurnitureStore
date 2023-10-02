package com.cognixia.jump;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognixia.jump.util.ItemTypes;
import com.cognixia.jump.util.ItemTypes.Category;
import com.cognixia.jump.util.ItemTypes.SubCategory;

@SpringBootApplication
public class FurnitureStoreApplication {

	public static void main(String[] args) {
		System.out.println("CATEGORIES  " + ItemTypes.getAllCategories().toArray());
		System.out.println("\nSUB CATEGORIES  " +ItemTypes.getAllSubCategories());
		System.out.println("\nMAP OF CATEGORIES  " + ItemTypes.types);
		System.out.println("\nSECOND MAP OF CATEGORIES  " + ItemTypes.types2);
		if(ItemTypes.types2.get(Category.BEDROOM).contains(SubCategory.BEDS)) {
			System.out.println("\n******************\nABLE TO REFERENCE VALUE");
		}
		SpringApplication.run(FurnitureStoreApplication.class, args);
	}

}
