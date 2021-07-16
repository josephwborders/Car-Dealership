package com.dealership.inventory;

import java.time.LocalDate;

public class Listing {
	
	private LocalDate dateListed;
	private int listingAge;
	public Vehicle vehicle;

	public Listing() {
	}

	public Listing(LocalDate dateListed, int listingAge, Vehicle vehicle) {
		super();
		this.dateListed = dateListed;
		this.listingAge = listingAge;
		this.vehicle = vehicle;
	}

	public LocalDate getDateListed() {
		return dateListed;
	}

	public void setDateListed(LocalDate dateListed) {
		this.dateListed = dateListed;
	}

	public int getListingAge() {
		return listingAge;
	}

	public void setListingAge(int listingAge) {
		this.listingAge = listingAge;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	

}
