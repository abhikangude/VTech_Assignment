package com.vtassignment.bean;

public class PizzaMenu {

	private String pizzaName;
	private String pSize;
	private int cost;
	private boolean vegan;
	
	public PizzaMenu() {
		super();
	}
	
	public PizzaMenu(String pizzaName, String size, int cost, boolean vegan) {
		super();
		this.pizzaName = pizzaName;
		this.pSize = size;
		this.cost = cost;
		this.vegan = vegan;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public String getSize() {
		return pSize;
	}

	public void setSize(String size) {
		this.pSize = size;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public boolean isVegan() {
		return vegan;
	}

	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	@Override
	public String toString() {
		return " " + pizzaName + "\t\t" + pSize + "\t\t" + cost + "  ";
	}
}
