package com.bridgelabz.cabinvoicegenerator;

import com.bridgelabz.cabinvoicegenerator.CabInoviceGenerator.RideType;

public class Ride {
	public double distance;
	public int time;
	private CabInoviceGenerator.RideType rideType;
	
	public Ride(double distance, int time,RideType rideType) {
		super();
		this.distance = distance;
		this.time = time;
		this.rideType = rideType;
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

	public CabInoviceGenerator.RideType getRideType() {
        return rideType;
    }

    public void setRideType(CabInoviceGenerator.RideType rideType) {
        this.rideType = rideType;
    }
	

	
}
