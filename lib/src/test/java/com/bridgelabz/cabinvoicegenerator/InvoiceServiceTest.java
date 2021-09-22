package com.bridgelabz.cabinvoicegenerator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import static com.bridgelabz.cabinvoicegenerator.CabInoviceGenerator.RideType.NORMAL;
import static com.bridgelabz.cabinvoicegenerator.CabInoviceGenerator.RideType.PREMIUM;
public class InvoiceServiceTest {

	@Test
	public void GivenDistanceAndTime_ShouldReturnTotalFare()throws CabInvoiceException
	{
		double distance = 2.0;
		int time = 5;
		CabInoviceGenerator cabInoviceGenerator = new  CabInoviceGenerator();
		double fare = cabInoviceGenerator.calculateFare(distance,time,NORMAL);
		Assert.assertEquals(25, fare,0.0);
		
	}
	
	@Test
	public void GivenLessDistanceAndTime_ShouldReturnMinimumFare() throws CabInvoiceException
	{
		double distance = 0.1;
		int time = 1;
		CabInoviceGenerator cabInoviceGenerator = new  CabInoviceGenerator();
		double minfare = cabInoviceGenerator.calculateFare(distance,time,NORMAL);
		Assert.assertEquals(5, minfare,0.0);

	}
	@Test
	public void GivenMultipleRides_ShouldReturnTotalOfAll() throws CabInvoiceException {
		CabInoviceGenerator cabInoviceGenerator = new  CabInoviceGenerator();
		Ride[] rides = { new Ride(2.0,5,NORMAL),
							new Ride(0.1,1,NORMAL)
						};
		double fare= cabInoviceGenerator.calculateFare1(rides);
		Assert.assertEquals(30, fare,0.0);
				
		}
	
	@Test
	public void GivenMultipleRides_ShouldReturnInvoiceSummary() throws CabInvoiceException
	{
		CabInoviceGenerator cabInoviceGenerator = new  CabInoviceGenerator();
		Ride[] rides = { new Ride(2.0,5,NORMAL),
				new Ride(0.1,1,NORMAL)
			};
		InvoiceSummary summary = cabInoviceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
	
	@Test
    public void givenUserIdAndRides_shouldReturnInvoiceSummary() throws CabInvoiceException  {
		CabInoviceGenerator cabInoviceGenerator = new  CabInoviceGenerator();
        String userId = "userOne";
        Ride[] rides = {new Ride(2.0, 5,NORMAL),
                         new Ride(0.1, 1,NORMAL)};
        cabInoviceGenerator.addRides(userId, rides);
        InvoiceSummary summary = cabInoviceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
	
	 @Test
	    public void givenUserIdRidesAndType_shouldReturnInvoiceSummary() throws CabInvoiceException {
		 	CabInoviceGenerator cabInoviceGenerator = new  CabInoviceGenerator();
	        String userId = "userOne";
	        Ride[] rides = {new Ride(2.0, 5, NORMAL),
	                new Ride(0.1, 1, NORMAL)};
	        cabInoviceGenerator.addRides(userId, rides);
	        InvoiceSummary summary = cabInoviceGenerator.getInvoiceSummary(userId);
	        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
	        Assert.assertEquals(expectedInvoiceSummary, summary);
	    }

	 @Test
	    public void givenCategories_WhenRideList_ShouldReturnInvoiceSummary() throws CabInvoiceException {
		 CabInoviceGenerator cabInoviceGenerator = new  CabInoviceGenerator();
	        String userId = "userOne";
	        Ride[] rides = {new Ride(2.0, 5, PREMIUM),
	                new Ride(0.1, 1, PREMIUM)};
	        cabInoviceGenerator.addRides(userId, rides);
	        InvoiceSummary summary = cabInoviceGenerator.getInvoiceSummary(userId);
	        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
	        Assert.assertEquals(expectedInvoiceSummary, summary);
	    }
	
}

