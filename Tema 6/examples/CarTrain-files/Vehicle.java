package com.javaproblems.vehicles;

public abstract class Vehicle {

	private String manufacturer;
	private String name;
	private Engine engine;
	private Body body;
	private double profit;

	public Vehicle(String manufacturer, String name, Engine engine, Body body, double profit) {
		this.manufacturer = manufacturer;
		this.name = name;
		this.engine = engine;
		this.body = body;
		this.profit = profit;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	protected abstract double calculateTotalPrice();

	public String toString() {
		return manufacturer + " " + name + "\n\nEngine:\n" + engine.getId() + " $" + engine.getCost() + "\n\nBody:\n"
				+ body.getWidth() + "x" + body.getHeight() + "M\n" + body.getSeats() + " seats\n";
	}
}
