package com.bridgelabz.cabinvoicegenerator;

import com.bridgelabz.cabinvoicegenerator.CabInoviceGenerator.RideType;

public interface CabInvoiceGeneratorIF {
	double calculateFare(double distance, int time, RideType rideType);
	public InvoiceSummary calculateFare(Ride[] rides);
	public double calculateBasedOnRideType(double distance, int time, RideType rideType);
}
