package com.ebookportal.spring.exception;

public class EbookstoreException extends Exception {

	public EbookstoreException(String message)
	{
		super(message);
	}
	
	public EbookstoreException(String message, Throwable cause)
	{
		super(message,cause);
	}
}
