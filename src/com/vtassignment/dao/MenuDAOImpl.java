package com.vtassignment.dao;

import java.util.ArrayList;
import java.util.List;

import com.vtassignment.bean.PizzaCrust;
import com.vtassignment.bean.PizzaMenu;
import com.vtassignment.bean.Sides;
import com.vtassignment.bean.Toppings;

public class MenuDAOImpl implements MenuDAO {

	private final List<PizzaMenu> pizzas= new ArrayList<>();
	private final List<PizzaCrust> crusts= new ArrayList<>();
	private final List<Toppings> topping= new ArrayList<>();
	private final List<Sides> sides= new ArrayList<>();
	
	public MenuDAOImpl() {
		constuctPizzaMenu();
		constuctCrustMenu();
		constuctToppingMenu();
		constructSideMenu();
	}
	
	private void constuctPizzaMenu() {
		pizzas.add(new PizzaMenu("Deluxe Veggie","Regular",150, true));
		pizzas.add(new PizzaMenu("Deluxe Veggie","Medium",200, true));
		pizzas.add(new PizzaMenu("Deluxe Veggie","Large",325, true));
		pizzas.add(new PizzaMenu("Cheese and Corn","Regular",175, true));
		pizzas.add(new PizzaMenu("Cheese and Corn","Medium",375, true));
		pizzas.add(new PizzaMenu("Cheese and Corn","Large",475, true));
		pizzas.add(new PizzaMenu("Paneer Tikka","Regular",160, true));
		pizzas.add(new PizzaMenu("Paneer Tikka","Medium",290, true));
		pizzas.add(new PizzaMenu("Paneer Tikka","Large",340, true));
		
		pizzas.add(new PizzaMenu("Non-Veg Supreme","Regular",190, false));
		pizzas.add(new PizzaMenu("Non-Veg Supreme","Medium",325, false));
		pizzas.add(new PizzaMenu("Non-Veg Supreme","Large",425, false));
		pizzas.add(new PizzaMenu("Chicken Tikka","Regular",210, false));
		pizzas.add(new PizzaMenu("Chicken Tikka","Medium",370, false));
		pizzas.add(new PizzaMenu("Chicken Tikka","Large",500, false));
		pizzas.add(new PizzaMenu("Pepper Barbeque Chicken","Regular",220, false));
		pizzas.add(new PizzaMenu("Pepper Barbeque Chicken","Medium",380, false));
		pizzas.add(new PizzaMenu("Pepper Barbeque Chicken","Large",525, false));
	}
	
	private void constuctCrustMenu() {
		crusts.add(new PizzaCrust("New Hand Tossed"));
		crusts.add(new PizzaCrust("Wheat Thin Crust"));
		crusts.add(new PizzaCrust("Cheese Burst"));
		crusts.add(new PizzaCrust("Fresh Pan Pizza"));
	}
	
	private void constuctToppingMenu() {
		topping.add(new Toppings("Black Olive",20,true));
		topping.add(new Toppings("Capsicum",25,true));
		topping.add(new Toppings("Paneer",35,true));
		topping.add(new Toppings("Mushroom",30,true));
		topping.add(new Toppings("Fresh Tomato",10,true));
		topping.add(new Toppings("Extra Cheese",35,true));
		topping.add(new Toppings("Chicken Tikka", 35, false));
		topping.add(new Toppings("Barbeque Chicken",45, false));
		topping.add(new Toppings("Grilled Chicken", 40, false));
	}
	
	private void constructSideMenu() {
		sides.add(new Sides("Cold Drink",55));
		sides.add(new Sides("Mousse Cake",90));
	}

	@Override
	public List<PizzaCrust> getCrusts() {
		return this.crusts;
	}

	@Override
	public List<PizzaMenu> getPizzas() {
		return this.pizzas;
	}

	@Override
	public List<Toppings> getToppings() {
		return this.topping;
	}

	@Override
	public List<Sides> getSides() {
		return this.sides;
	}
}
