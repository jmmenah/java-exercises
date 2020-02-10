package com.javaproblems.vehicles;

public class Body {

	private double width;
	private double height;
	private int seats;
	private double cost;

	public Body(double width, double height, int seats, double cost) {
		this.width = width;
		this.height = height;
		this.seats = seats;
		this.cost = cost;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String toString() {
		return "Body:\n" + width + "x" + height + "M " + seats + " seats\n\n";
	}
}