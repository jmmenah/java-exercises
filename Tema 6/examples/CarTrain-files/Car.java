package com.javaproblems.vehicles;

public class Car extends Vehicle {

	private int doors;
	private String gear;
	private double gearPrice;

	public Car(String manufacturer, String name, Engine engine, Body body, double profit, int doors, String gear,
			double gearPrice) {
		super(manufacturer, name, engine, body, profit);
		this.doors = doors;
		this.gear = gear;
		this.gearPrice = gearPrice;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public String getGear() {
		return gear;
	}

	public void setGear(String gear) {
		this.gear = gear;
	}

	public double getGearPrice() {
		return gearPrice;
	}

	public void setGearPrice(double gearPrice) {
		this.gearPrice = gearPrice;
	}

	@Override
	protected double calculateTotalPrice() {
		return getEngine().getCost() + getBody().getCost() + getProfit() + gearPrice;
	}

	public String toString() {
		return super.toString() + doors + " doors\n\nPrice:\n$" + calculateTotalPrice() + "\n\n";
	}
}