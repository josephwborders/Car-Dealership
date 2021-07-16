package com.app.dealer.model;

public abstract class Area implements Calc{
	
	public static final String doing = "dsgsfhfsh";
	
    public abstract int area(int a, int b,  int c);
    
	double triangle(int a, int b) {
		
		return 1/2*a*b;
	}
	
	double circle(int a) {
		
		return 3.14*a*a;
	}
	
	int calculatearea() {
		return 0;
	}
	
	

}
