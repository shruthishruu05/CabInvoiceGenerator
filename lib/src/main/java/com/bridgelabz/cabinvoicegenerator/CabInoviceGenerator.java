package com.bridgelabz.cabinvoicegenerator;

public class CabInoviceGenerator implements CabInvoiceGeneratorIF 
{
	private static final double MINIIMUM_COST_PER_KILOMETER = 10;
	private static final int MINIMUM_TIME = 1;
	private static final double  MINIMUM_FARE = 5;
	
	
	public CabInoviceGenerator() {
		
	}
	@Override
	public double calculateFare(double distance, int time) {
		double totalFare = distance*MINIIMUM_COST_PER_KILOMETER+time*MINIMUM_TIME;
		if(totalFare < MINIMUM_FARE)
			return MINIMUM_FARE;
		return totalFare;
			
			
	}
	public double calculateFare(Ride[] rides) {
		// TODO Auto-generated method stub
		double totalfare=0;
		for(Ride ride : rides)
		{
			totalfare += this.calculateFare(ride.distance,ride.time);
		}
		return totalfare;
	}

}
