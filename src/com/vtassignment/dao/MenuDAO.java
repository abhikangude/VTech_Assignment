package com.vtassignment.dao;

import java.util.List;

import com.vtassignment.bean.PizzaCrust;
import com.vtassignment.bean.PizzaMenu;
import com.vtassignment.bean.Sides;
import com.vtassignment.bean.Toppings;

public interface MenuDAO {
	
	List<PizzaCrust> getCrusts();

	List<PizzaMenu> getPizzas();

	List<Toppings> getToppings();

	List<Sides> getSides();
}
