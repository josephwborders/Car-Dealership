package com.app.dealer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.dealer.model.Calc;

@SpringBootApplication
public class DealerApplication implements CommandLineRunner{
	
	private static final Logger log=LoggerFactory.getLogger("DealerApplication.class");
	
	@Autowired
	private Calc calculation;

	public static void main(String[] args) {
		SpringApplication.run(DealerApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(calculation.area(0.3));
		log.info("Area of acircle {} ", calculation.area(3.3));
		log.info("Area of Triangle {} ",calculation.area(3,3));
		log.info("Area of Rectangle {} ",calculation.area(3,2,4));
		
	}

	
	

}
