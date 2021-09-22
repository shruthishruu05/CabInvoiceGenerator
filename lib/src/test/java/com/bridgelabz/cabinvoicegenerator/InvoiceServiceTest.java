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
}
