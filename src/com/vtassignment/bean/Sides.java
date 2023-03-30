package com.vtassignment.bean;

public class Sides {
	private String side;
	private int cost;
	
	public Sides() {
		super();
	}
	
	public Sides(String side, int cost) {
		super();
		this.side = side;
		this.cost = cost;
	}
	
	public String getSide() {
		return side;
	}
	
	public void setSide(String sides) {
		this.side = sides;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return side+ "\t\t"+ cost;
	}
	
}
