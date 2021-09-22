package com.bridgelabz.cabinvoicegenerator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {

	@Test
	public void GivenDistanceAndTime_ShouldReturnTotalFare()
	{
		double distance = 2.0;
		int time = 5;
		CabInoviceGenerator cabInoviceGenerator = new  CabInoviceGenerator();
		double fare = cabInoviceGenerator.calculateFare(distance,time);
		Assert.assertEquals(25, fare,0.0);
		
	}
	
	@Test
	public void GivenLessDistanceAndTime_ShouldReturnMinimumFare() 
	{
		double distance = 0.1;
		int time = 1;
		CabInoviceGenerator cabInoviceGenerator = new  CabInoviceGenerator();
		double minfare = cabInoviceGenerator.calculateFare(distance,time);
		Assert.assertEquals(5, minfare,0.0);

	}
	@Test
	public void GivenMultipleRides_ShouldReturnTotalOfAll()  {
		CabInoviceGenerator cabInoviceGenerator = new  CabInoviceGenerator();
		Ride[] rides = { new Ride(2.0,5),
							new Ride(0.1,1)
						};
		double fare= cabInoviceGenerator.calculateFare1(rides);
		Assert.assertEquals(30, fare,0.0);
				
		}
	
	@Test
	public void GivenMultipleRides_ShouldReturnInvoiceSummary() 
	{
		CabInoviceGenerator cabInoviceGenerator = new  CabInoviceGenerator();
		Ride[] rides = { new Ride(2.0,5),
				new Ride(0.1,1)
			};
		InvoiceSummary summary = cabInoviceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
	
	@Test
    public void givenUserIdAndRides_shouldReturnInvoiceSummary()  {
		CabInoviceGenerator cabInoviceGenerator = new  CabInoviceGenerator();
        String userId = "userOne";
        Ride[] rides = {new Ride(2.0, 5),
                         new Ride(0.1, 1)};
        cabInoviceGenerator.addRides(userId, rides);
        InvoiceSummary summary = cabInoviceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
	
}

