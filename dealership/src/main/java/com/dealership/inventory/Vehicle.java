package com.dealership.inventory;

public class Vehicle {

	private int stockNumber;
	private String newOrUsed;
	private String type;
	private double price;
	private int year;
	private String make;
	private String model;
	private String color;
	private int mileage;
	private String engine;
	private String transmission;
	private String features;
	private String imagePath;
	
	public Vehicle() {
	}

	public Vehicle(int stockNumber, String newOrUsed, String type, double price, int year, String make, String model, String color,
			int mileage, String engine, String transmission, String features, String imagePath) {
		super();
		this.stockNumber = stockNumber;
		this.newOrUsed = newOrUsed;
		this.type = type;
		this.price = price;
		this.year = year;
		this.make = make;
		this.model = model;
		this.color = color;
		this.mileage = mileage;
		this.engine = engine;
		this.transmission = transmission;
		this.features = features;
		this.imagePath = imagePath;
	}

	public int getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}

	public String getNewOrUsed() {
		return newOrUsed;
	}

	public void setNewOrUsed(String newOrUsed) {
		this.newOrUsed = newOrUsed;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
