package com.bridgelabz.cabinvoicegenerator;

public class CabInoviceGenerator implements CabInvoiceGeneratorIF 
{
	private static final double MIN_COST_PER_KM_NORMAL_RIDE = 10;
    private static final int COST_PER_TIME_NORMAL_RIDE = 1;
    private static final double MIN_FARE_NORMAL_RIDE = 5;
    private static final double MIN_COST_PER_KM_PREMIUM_RIDE = 15;
    private static final int COST_PER_TIME_PREMIUM_RIDE = 2;
    private static final double MIN_FARE_PREMIUM_RIDE = 20;
	
	RideRepository rideRepository = new RideRepository();
	
	public enum RideType {
        NORMAL, PREMIUM
    }
	public CabInoviceGenerator() {
		
	}
	
	@Override
	public double calculateFare(double distance, int time,RideType rideType) {
		double totalFare = distance*MIN_COST_PER_KM_NORMAL_RIDE+time*COST_PER_TIME_NORMAL_RIDE;
		if(totalFare < MIN_FARE_NORMAL_RIDE)
			return MIN_FARE_NORMAL_RIDE;
		return totalFare;
			
			
	}
	public double calculateFare1(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare =totalFare+ this.calculateFare(ride.getDistance(), ride.getTime(),ride.getRideType());
        }
        return totalFare;
    }
	public InvoiceSummary calculateFare(Ride[] rides) {
		// TODO Auto-generated method stub
		double totalfare=0;
		for(Ride ride : rides)
		{
			totalfare += this.calculateFare(ride.getDistance(), ride.getTime(),ride.getRideType());
		}
		return new InvoiceSummary(rides.length, totalfare);
	}
	public void addRides(String userId, Ride[] rides) {
		// TODO Auto-generated method stub
		rideRepository.addRides(userId, rides);
	}
	public InvoiceSummary getInvoiceSummary(String userId) {
		// TODO Auto-generated method stub
		return this.calculateFare(rideRepository.getRides(userId));
	}
	public double calculateBasedOnRideType(double distance, int time, RideType rideType) 
    {
		double totalFare=0;
        if(rideType == RideType.PREMIUM)
        {
        	return totalFare = Math.max(distance * MIN_COST_PER_KM_PREMIUM_RIDE + time * COST_PER_TIME_PREMIUM_RIDE,
	                    MIN_FARE_PREMIUM_RIDE);	
        }
        else if(rideType == RideType.NORMAL) {
           
           return totalFare= Math.max(distance * MIN_COST_PER_KM_NORMAL_RIDE + time * COST_PER_TIME_NORMAL_RIDE,
                    MIN_FARE_NORMAL_RIDE);
        }
		return time;
    }

}
