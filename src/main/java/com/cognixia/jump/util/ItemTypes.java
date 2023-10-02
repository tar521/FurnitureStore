package com.cognixia.jump.util;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemTypes {
	
	public static final Map<SubCategory, Category> types = new HashMap<SubCategory, Category>();
	
	public static final Map<Category, List<SubCategory> > types2 = new HashMap<Category, List<SubCategory> >();
	
	public static enum Category {
		LIVING_ROOM, BEDROOM, DINING_ROOM, HOME_OFFICE, SHELVES
	}
	
	public static enum SubCategory {
		SOFA, LOVESEATS, SECTIONAL_SOFAS, SLEEPER_SOFAS, FUTONS, RECLINING_FURNITURE, RECLINERS, CHAIRS, OTTOMANS,
        COFFEE_TABLES,
        END_SIDE_TABLES,
        TV_STANDS,
        BEDS,
    	BEDROOM_SETS,
    	HEADBOARDS,
    	DRESSERS_CHESTS,
    	MIRRORED_DRESSERS,
    	NIGHTSTANDS,
    	MAKEUP_VANITIES,
    	DINING_ROOM_SETS,
    	DINING_ROOM_TABLES,
    	DINING_ROOM_CHAIRS,
    	BAR_STOOLS,
    	DINING_BENCHES,
    	DINING_STORAGE,
    	BAR_FURNITURE,
    	DESKS,
    	BOOKCASES,
    	OFFICE_CHAIRS,
    	OFFICE_SETS,
    	OFFICE_STORAGE,
    	GAMING,
    	ACCENT_FURNITURE,
    	ACCENT_CHAIRS,
    	ACCENT_TABLES,
    	ACCENT_CABINETS,
    	BENCHES,
    	BAR_CARTS,
    	BOOK_SHELVES,
    	HANGING_SHELVES,
    	MOUNTED_SHELVES
  	}
	
	static {
		
		
		List<SubCategory> living = new ArrayList<SubCategory>();
		List<SubCategory> bed = new ArrayList<SubCategory>();
		List<SubCategory> dine = new ArrayList<SubCategory>();
		List<SubCategory> office = new ArrayList<SubCategory>();
		List<SubCategory> shelves = new ArrayList<SubCategory>();
		
		for(SubCategory s : EnumSet.allOf(SubCategory.class)) {
			if (s.ordinal() < 12 ) {
				types.put(s, Category.LIVING_ROOM);
				living.add(s);
			} else if (s.ordinal() < 19) {
				types.put(s,  Category.BEDROOM);
				bed.add(s);
			} else if (s.ordinal() < 26) {
				types.put(s, Category.DINING_ROOM);
				dine.add(s);
			} else if (s.ordinal() < 38) {
				types.put(s, Category.HOME_OFFICE);
				office.add(s);
			} else {
				types.put(s, Category.SHELVES);
				shelves.add(s);
			}
		}
		
		types2.put(Category.LIVING_ROOM, living);
		types2.put(Category.BEDROOM, bed);
		types2.put(Category.DINING_ROOM, dine);
		types2.put(Category.HOME_OFFICE, office);
		types2.put(Category.SHELVES, shelves);
	}
	
	public static EnumSet<Category> getAllCategories(){
		return EnumSet.allOf(Category.class);
	}
	
	public static EnumSet<SubCategory> getAllSubCategories(){
		return EnumSet.allOf(SubCategory.class);
	}
	

}
