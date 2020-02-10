package com.javaproblems.vehicles;

public class Engine {

	private String id;
	private double cost;

	public Engine(String id, double cost) {
		this.id = id;
		this.cost = cost;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String toString() {
		return "";
	}
}
