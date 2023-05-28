package com.bankApplications.exceptions;

public class InsufficientBalanceException extends Exception 
{
		public InsufficientBalanceException(String msg)
		{
			super(msg);
		}
}
