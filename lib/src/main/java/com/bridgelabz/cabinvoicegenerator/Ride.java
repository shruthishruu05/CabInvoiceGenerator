package com.bridgelabz.cabinvoicegenerator;

public class Ride {
	public double distance;
	public int time;
	public Ride(double distance, int time) {
		super();
		this.distance = distance;
		this.time = time;
	}
	
	public double getDistance() {
		return distance;
	}
	public int getTime() {
		return time;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public void setTime(int time) {
		this.time = time;
	}
	

	
}
