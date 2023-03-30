package com.vtassignment.service;

import java.util.List;

import com.vtassignment.bean.PizzaCrust;
import com.vtassignment.bean.PizzaMenu;
import com.vtassignment.bean.Sides;
import com.vtassignment.bean.Toppings;
import com.vtassignment.dao.MenuDAO;
import com.vtassignment.dao.MenuDAOImpl;

public class MenuServiceImpl implements MenuService {
	
	private final MenuDAO menuDAO = new MenuDAOImpl();
	
	@Override
	public void displayPizza() {
		List<PizzaMenu> pizzMenus = menuDAO.getPizzas();
		int i=1;
		System.out.println("\t\tRocket Pizza Menu\n");
		System.out.println("\t\tVegetarian Pizza   ");
		for(PizzaMenu pm:pizzMenus) {
			if(pm.isVegan()) {
				System.out.println(i+" "+pm);
				i++;
			}
		}
		System.out.println("\t\tNon-Vegetarian Pizza   ");
		for(PizzaMenu pm:pizzMenus) {
			if(!pm.isVegan()) {
				System.out.println(i+ " "+pm);
				i++;
			}
		}
		System.out.println();
	}
	
	@Override
	public void displayPCrust() {
		List<PizzaCrust> pizzaCrusts=menuDAO.getCrusts();
		int i=1;
		System.out.println("Types of Pizza Crust\n");
		for(PizzaCrust pizzaCrust:pizzaCrusts) {
			System.out.println(i+" "+pizzaCrust);
			i++;
		}
		System.out.println();
	}
	
	@Override
	public void displayPToppings() {
		List<Toppings> toppings=menuDAO.getToppings();
		int i=1;
		System.out.println("\t\tRocket Pizza Menu\n");
		System.out.println("\t\tExtra Toppings\n\t\tVegetarian Pizza   ");
		for(Toppings topping:toppings) {
			if(topping.isVegan()) {
				System.out.println(i+" "+topping);
				i++;
			}
		}
		System.out.println("\t\tNon-Vegetarian Pizza   ");
		for(Toppings topping:toppings) {
			if(!topping.isVegan()) {
				System.out.println(i+ " "+topping);
				i++;
			}
		}
		System.out.println();
	}
	
	@Override
	public void displayPSides() {
		List<Sides> pSides=menuDAO.getSides();
		int i=1;
		System.out.println("\tRocket Pizza Menu\n");
		System.out.println("\t    Sides");
		for(Sides ps:pSides) {
			System.out.println(i+ " "+ps);
			i++;
		}
	}

	@Override
	public List<PizzaCrust> getCrusts() {
		return menuDAO.getCrusts();
	}

	@Override
	public List<PizzaMenu> getPizzas() {
		return menuDAO.getPizzas();
	}

	@Override
	public List<Toppings> getToppings() {
		return menuDAO.getToppings();
	}

	@Override
	public List<Sides> getSides() {
		return menuDAO.getSides();
	}
	
}
