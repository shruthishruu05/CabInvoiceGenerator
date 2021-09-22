package com.bridgelabz.cabinvoicegenerator;

	public class CabInvoiceException extends Exception
	{
		public enum ExceptionType {
		     USER_NOT_EXIST, USER_ALREADY_EXISTS
		    }

		    public ExceptionType type;

		    public CabInvoiceException(String message, ExceptionType type) {
		        super(message);
		        this.type = type;
		    }
	}
