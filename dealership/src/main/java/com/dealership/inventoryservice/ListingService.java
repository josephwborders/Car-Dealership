package com.dealership.inventoryservice;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.dealership.inventory.Listing;
import com.dealership.inventory.Vehicle;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ListingService {

	public List<Listing> activeList = new LinkedList<>();
	
	// method to generate vehicle stock number for newly created vehicle/listing objects
	public int generateStockNumber() {
		int count = activeList.size()+1;
		count++;
		return count;
	}
	// method to calculate listing age for newly created listing objects
	public int calcListingAge(LocalDate dateListed) {
		LocalDate test = dateListed;
		int listingAge = (int) ChronoUnit.DAYS.between(test, LocalDate.now());
		return listingAge;
	}
	//method to return a list of all listings in "activeList"
	public List<Listing> listAll() {
		return activeList;
	}
	// method to find a listing object by it's vehicle object's stock number
	public Listing findByStockNumber(int stockNumber) {
		Listing display = new Listing();
		for (Listing item : activeList) {
			int displayItem = item.vehicle.getStockNumber();
			if (stockNumber == displayItem) {
				display = item;
				return display;
			}
		}
		return null;
	}
	// method to return a list of listing objects matching a given search keyword
	public List<Listing> search(String keyword){
		List<Listing> matches = new LinkedList<Listing>();
		for (Listing match : activeList) {
			if (match.vehicle.getNewOrUsed().equalsIgnoreCase(keyword) || match.vehicle.getMake().equalsIgnoreCase(keyword)
					|| match.vehicle.getModel().equalsIgnoreCase(keyword) || match.vehicle.getType().equalsIgnoreCase(keyword)) {
				matches.add(match);
			}
		}
		return matches;
	}
//**code below this line is only for setting default listings********************************************************************	
	// add default listings to list "activeList"
	@PostConstruct
	public void defaultListings() {
		Listing listing1 = new Listing();
		listing1.setDateListed(LocalDate.of(2021, 05, 20));
		listing1.setListingAge(0);
		listing1.setVehicle(new Vehicle(10001, "Used", "Car", 105000, 2016, "Porsche", "911 Turbo Coupe", "Silver",
				45000, "3.8L Turbo", "automatic", "Air Conditioning, Alarm/Anti-Theft System, AM/FM Radio, Bluetooth "
						+ "System, CD Player, Climate Control, Heat, Keyless Entry, Leather Seats, Navigation System,"
						+ " Parking Sensors, Performance Tyres, Power Locks, Power Mirrors, Power Seats, Power Sunroof, "
						+ "Power Windows, Premium Lights, Premium Sound System, Premium Wheels/Rims, Rear View Camera, "
						+ "Spoiler.", "assets/img/cars/911turboCoupe.jpg"));
		
		Listing listing2 = new Listing();
		listing2.setDateListed(LocalDate.of(2021, 06, 20));
		listing2.setListingAge(0);
		listing2.setVehicle(new Vehicle(10002, "New", "Car", 175000, 2021, "Audi", "RSQ8", 
				"Black", 0, "4.0L Quattro V8", "automatic", "600HP, Climate Control, Cooled Seats, DVD Player, Keyless Entry, "
						+ "Leather Seats, Navigation System, Parking Sensors, Premium Sound System, Rear View Camera.",
						"assets/img/cars/audiRSQ8.jpg"));
		
		Listing listing3 = new Listing();
		listing3.setDateListed(LocalDate.of(2021, 04, 12));
		listing3.setListingAge(0);
		listing3.setVehicle(new Vehicle(10003, "New", "Truck", 92000, 2020, "Toyota", "Land Cruiser 300",
				"Black", 0, "3.5L V6", "automatic", "Air Conditioning, Alarm/Anti-Theft System, AM/FM Radio,"
						+ " Bluetooth System, Climate Control, Fog Lights, Keyless Entry, Keyless Start, Moonroof,"
						+ " Parking Sensors, Performance Tyres, Power Locks, Power Mirrors, Power Seats, Power Sunroof,"
						+ " Power Windows, Premium Lights, Premium Paint, Premium Wheels/Rims, Rear View Camera,"
						+ " Roof Rack, Spoiler, Sunroof.", "assets/img/cars/landCruiser.jpg"));
		
		Listing listing4 = new Listing();
		listing4.setDateListed(LocalDate.of(2021, 05, 03));
		listing4.setListingAge(0);
		listing4.setVehicle(new Vehicle(10004, "Used", "Car", 18500, 2018, "Honda", "Accord", "Red",
				26000, "1.5L Turbo 4-Cyl", "automatic", "\r\n"
						+ "Air Conditioning, Alarm/Anti-Theft System, AM/FM Radio, Aux Audio In, Bluetooth System, Body Kit,"
						+ " Brush Guard, CD Player, Climate Control, DVD Player, Fog Lights, Heat, Keyless Entry, Leather Seats,"
						+ " Parking Sensors, Performance Tyres, Power Locks, Power Mirrors, Power Windows, Premium Lights,"
						+ " Premium Paint, Premium Sound System, Premium Wheels/Rims, Racing Seats, Rear View Camera,"
						+ " Satellite Radio", "assets/img/cars/hondaAccord.jpg"));
		
		Listing listing5 = new Listing();
		listing5.setDateListed(LocalDate.of(2021, 02, 21));
		listing5.setListingAge(0);
		listing5.setVehicle(new Vehicle(10005, "Used", "Truck", 75800, 2018, "Ford", "Raptor", "Black",
				19500, "3.5L V6", "automatic", "4x4, Air Conditioning, Alarm/Anti-Theft System, AM/FM Radio, Aux Audio In,"
						+ " Bluetooth System, CD Player, Climate Control, Fog Lights, Heat, Heated Seats, Keyless Start,"
						+ " Leather Seats, Navigation System, Parking Sensors, Power Locks, Power Mirrors, Power Seats, Power Windows,"
						+ " Premium Lights, Premium Wheels/Rims, Rear View Camera", "assets/img/cars/raptor.jpg"));
		
		Listing listing6 = new Listing();
		listing6.setDateListed(LocalDate.of(2021, 06, 04));
		listing6.setListingAge(0);
		listing6.setVehicle(new Vehicle(10006, "Used", "Motorcycle", 14295, 2018, "BMW", "S1000RR", "Red",
				62000, "1000cc I4", "6-speed", "No Accidents, No Falls, Clean Bike, Ready to Ride, Full System Two Brothers Exhaust,"
						+ " Service Done Last Week, New Tires METZELER, R&G Crash Protectors", "assets/img/cars/s1000rr.jpg"));
		
		Listing listing7 = new Listing();
		listing7.setDateListed(LocalDate.of(2021, 01, 01));
		listing7.setListingAge(0);
		listing7.setVehicle(new Vehicle(10007, "Used", "Van", 7599, 1988, "Ford", "Econoline 150", "Merlot",
				295000, "5.8L V8 Windsor", "automatic", "Great for kids, no windows, AM/FM radio with cassette deck and aux jack, "
						+ "duct tape and canvas bags under driver seat are included in the sale", "assets/img/cars/freeCandy.jpg"));
		
		Listing listing8 = new Listing();
		listing8.setDateListed(LocalDate.of(2021, 03, 21));
		listing8.setListingAge(0);
		listing8.setVehicle(new Vehicle(10008, "new", "Truck", 55800, 2021, "Chevrolet", "Tahoe", "Blue",
				0, "5.3L V8", "automatic", "\r\n"
						+ "Air Conditioning, Alarm/Anti-Theft System, AM/FM Radio, Aux Audio In, Bluetooth System, Climate Control,"
						+ " Cooled Seats, Fog Lights, Heated Seats, Keyless Entry, Keyless Start, Leather Seats, Navigation System,"
						+ " Parking Sensors, Power Locks, Power Mirrors, Power Seats, Power Sunroof, Power Windows, Premium Lights,"
						+ " Premium Sound System, Premium Wheels/Rims, Rear View Camera, Sunroof", "assets/img/cars/tahoe.jpg"));
		
		Listing listing9 = new Listing();
		listing9.setDateListed(LocalDate.of(2021, 07, 01));
		listing9.setListingAge(0);
		listing9.setVehicle(new Vehicle(10009, "New", "Truck", 95950, 2021, "Land Rover", "Defender", "Gold",
				0, "2.0L Turbo 4-Cyl", "automatic", "Air Conditioning, Alarm/Anti-Theft System, AM/FM Radio, Aux Audio In, "
						+ " Bluetooth System, Body Kit, Brush Guard, Cassette Player, CD Player, Climate Control, Cooled Seats, "
						+ " DVD Player, Fog Lights, Heated Seats, Keyless Entry, Keyless Start, Leather Seats, Moonroof, Navigation System,"
						+ " Off-Road Kit, Off-Road Tires, Parking Sensors, Performance Tyres, Power Locks, Power Mirrors, Power Seats,"
						+ " Power Sunroof, Power Windows, Premium Lights, Premium Paint, Premium Sound System, Premium Wheels/Rims,"
						+ " Rear View Camera, Roof Rack, Sunroof", "assets/img/cars/defender.jpg"));
		
		Listing listing10 = new Listing();
		listing10.setDateListed(LocalDate.of(2021, 06, 18));
		listing10.setListingAge(0);
		listing10.setVehicle(new Vehicle(10010, "Used", "Truck", 21700, 2015, "Volkwagen", "Touareg", "White",
				19500, "3.0L V6", "automatic", "Air Conditioning, AM/FM Radio, Aux Audio In, Bluetooth System, Climate Control,"
						+ " Fog Lights, Leather Seats, Moonroof, Navigation System, Parking Sensors, Power Locks, Power Mirrors,"
						+ " Power Seats, Power Sunroof, Power Windows, Premium Lights, Premium Sound System, Rear View Camera",
						"assets/img/cars/touareg.jpg"));
		
		Listing listing11 = new Listing();
		listing11.setDateListed(LocalDate.of(2021, 02, 21));
		listing11.setListingAge(0);
		listing11.setVehicle(new Vehicle(10011, "Used", "Car", 21450, 2020, "Mini", "Cooper", "Green",
				4500, "1.5L 3-Cyl", "automatic", "Air Conditioning, Alarm/Anti-Theft System, AM/FM Radio, Aux Audio In, Bluetooth System,"
						+ " Body Kit, Brush Guard, Cassette Player, CD Player, Climate Control, DVD Player, Fog Lights, Heat,"
						+ " Heated Seats, Keyless Start, Leather Seats, Moonroof, Navigation System, Parking Sensors, Performance Tires,"
						+ " Power Locks, Power Mirrors, Power Sunroof, Power Windows, Premium Lights, Premium Sound System, Rear View Camera,"
						+ " Satellite Radio, Spoiler, Sunroof", "assets/img/cars/mini.jpg"));
		
		Listing listing12 = new Listing();
		listing12.setDateListed(LocalDate.of(2021, 05, 29));
		listing12.setListingAge(0);
		listing12.setVehicle(new Vehicle(10012, "Used", "Truck", 24000, 2019, "Mazda", "CX-5", "Blue",
				18200, "2.5L 4-Cyl", "automatic", "Alarm/Anti-Theft System, AM/FM Radio, Aux Audio In, Bluetooth System, Brush Guard,"
						+ " CD Player, Climate Control, Fog Lights, Keyless Entry, Navigation System, Performance Tyres, Power Locks,"
						+ " Power Mirrors, Power Windows, Premium Lights, Premium Paint, Premium Sound System, Premium Wheels/Rims,"
						+ " Spoiler", "assets/img/cars/cx5.jpg"));
		
		Listing listing13 = new Listing();
		listing13.setDateListed(LocalDate.of(2021, 02, 21));
		listing13.setListingAge(0);
		listing13.setVehicle(new Vehicle(10013, "Used", "Car", 162000, 2017, "Aston Martin", "DB11", "Black",
				16700, "5.2L V12", "automatic", "Climate Control, Cooled Seats, DVD Player, Keyless Entry, Leather Seats,"
						+ " Navigation System, Parking Sensors, Premium Sound System, Rear View Camera", "assets/img/cars/db11.jpg"));
		
		activeList.add(listing1); activeList.add(listing2); activeList.add(listing3); activeList.add(listing4);
		activeList.add(listing5); activeList.add(listing6); activeList.add(listing7); activeList.add(listing8);
		activeList.add(listing9); activeList.add(listing10); activeList.add(listing11); activeList.add(listing12);
		activeList.add(listing13);
		
		// listing age setter for static listing objects
		for (Listing item : activeList) {
			int age = (int) ChronoUnit.DAYS.between(item.getDateListed(), LocalDate.now());
			item.setListingAge(age);
		}

	}
}
