package com.bankApplications.exceptions;

public class InvalidAccountNumberException extends Exception
{
	public InvalidAccountNumberException(String msg)
	{
		super(msg);
	}
}
