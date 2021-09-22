package com.bridgelabz.cabinvoicegenerator;

public class InvoiceSummary {

	private int noOfRides;
	private double totalFare;
	private double average; 
	

	public InvoiceSummary(int noOfRides, double totalFare) {
		this.noOfRides = noOfRides;
		this.totalFare =totalFare;
		this.average = this.totalFare/this.noOfRides;
	}


	public int getNoOfRides() {
		return noOfRides;
	}


	public double getTotalFare() {
		return totalFare;
	}


	public double getAverage() {
		return average;
	}


	public void setNoOfRides(int noOfRides) {
		this.noOfRides = noOfRides;
	}


	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}


	public void setAverage(double average) {
		this.average = average;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj==null||getClass() != obj.getClass())
			return false;
		InvoiceSummary that = (InvoiceSummary) obj;
		return noOfRides == that.noOfRides && Double.compare(that.totalFare, totalFare)==0 && Double.compare(that.average, average)==0;
	}
	
}
