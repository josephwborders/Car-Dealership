package com.app.dealer.model;

import org.springframework.stereotype.Component;

@Component
public class CalculationsImpl implements Calc {

	@Override
	public int area(int a, int b) {		
		return a*b;
	}

	@Override
	public int area(int a) {
		
		return 3*a*a;
	}

	@Override
	public int area(int a, int b, int c) {
		
		return a+b/2;
	}

	@Override
	public double area(double a) {
		a=(3.14*a*a);
		return a;
	}


	
}
