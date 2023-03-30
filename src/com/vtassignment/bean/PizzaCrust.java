package com.vtassignment.bean;

public class PizzaCrust {
	
	private String crustType;

	public PizzaCrust() {
		super();
	}

	public PizzaCrust(String crustType) {
		super();
		this.crustType = crustType;
	}

	public String getCrustType() {
		return crustType;
	}

	public void setCrustType(String crustType) {
		this.crustType = crustType;
	}

	@Override
	public String toString() {
		return " " + crustType;
	}
}
