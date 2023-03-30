package com.vtassignment.bean;

public class Toppings {
	private String toppingName;
	private boolean vegan;
	private int cost;
	
	public Toppings() {
		super();
	}
	
	public Toppings(String toppingName, int cost) {
		super();
		this.toppingName = toppingName;
		this.cost = cost;
	}

	public Toppings(String toppingName, int cost, boolean isVegan) {
		super();
		this.toppingName = toppingName;
		this.cost=cost;
		this.vegan = isVegan;
	}

	public String getToppingName() {
		return toppingName;
	}
	
	public void setToppingName(String toppingName) {
		this.toppingName = toppingName;
	}
	
	public boolean isVegan() {
		return vegan;
	}
	
	public void setVegan(boolean isVegan) {
		this.vegan = isVegan;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return " " + toppingName + "\t\t" + cost;
	}}
