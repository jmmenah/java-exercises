package com.javaproblems.vehicles;

public class Train extends Vehicle {

	private int compartments;
	private String fuel;
	private double compartmentPrice;

	public Train(String manufacturer, String name, Engine engine, Body body, double profit, int compartments,
			String fuel, double compartmentPrice) {
		super(manufacturer, name, engine, body, profit);
		this.compartments = compartments;
		this.fuel = fuel;
		this.compartmentPrice = compartmentPrice;
	}

	public int getCompartments() {
		return compartments;
	}

	public void setCompartments(int compartments) {
		this.compartments = compartments;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public double getCompartmentPrice() {
		return compartmentPrice;
	}

	public void setCompartmentPrice(double compartmentPrice) {
		this.compartmentPrice = compartmentPrice;
	}

	@Override
	protected double calculateTotalPrice() {
		return getEngine().getCost() + getBody().getCost() + getProfit() + (compartments * compartmentPrice);
	}

	public String toString() {
		return super.toString() + compartments + " compartments\n\nPrice:\n$" + calculateTotalPrice() + "\n\n";
	}
}
