package com.vtassignment.service;

import java.util.List;

import com.vtassignment.bean.PizzaCrust;
import com.vtassignment.bean.PizzaMenu;
import com.vtassignment.bean.Sides;
import com.vtassignment.bean.Toppings;

public interface MenuService {

	void displayPizza();
	void displayPCrust();
	void displayPToppings();
	void displayPSides();
	List<PizzaCrust> getCrusts();
	List<PizzaMenu> getPizzas();

	List<Toppings> getToppings();

	List<Sides> getSides();
}
