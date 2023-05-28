package com.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.bankApplications.exceptions.InsufficientBalanceException;
import com.bankApplications.exceptions.InvalidAccountNumberException;
import com.bankApplications.exceptions.NegativeAmountException;
import com.bankApplications.exceptions.SameAccountNumberException;
import com.bankApplications.services.BankApplicationServicesImpl;
import com.bankApplications.services.BankApplicationsServices;
public class Tests 
{
	
	
		 BankApplicationsServices bankApplicationServerServicesImpl;
		
		
		public Tests() 
		{
			bankApplicationServerServicesImpl = new BankApplicationServicesImpl();
		}
		
		@Test
		public void depositTest() throws InvalidAccountNumberException, InsufficientBalanceException, NegativeAmountException {
			try 
			{
			assertEquals(1100, bankApplicationServerServicesImpl.deposit(11, 100), 0.001);
			}
			catch(InvalidAccountNumberException e)
			{
				System.out.println(e);
			}
			catch(InsufficientBalanceException e)
			{
				System.out.println(e);
			}
			catch(NegativeAmountException e)
			{
				System.out.println(e);
			}
		}
		@Test
		public void withdrawTest() throws InvalidAccountNumberException, InsufficientBalanceException, NegativeAmountException
		{
			try {
				assertEquals(4800,bankApplicationServerServicesImpl.withdraw(13, 200),0);
			}
			catch(InvalidAccountNumberException e)
			{
				System.out.println(e);
			}
			catch(InsufficientBalanceException e)
			{
				System.out.println(e);
			}
			catch(NegativeAmountException e)
			{
				System.out.println(e);
			}
			
		}
		@Test
		public void withdrawTest2() throws InvalidAccountNumberException, InsufficientBalanceException, NegativeAmountException
		{
			try
			{
			assertEquals(3800,bankApplicationServerServicesImpl.withdraw(16, 200),0.001);
			}
			catch(InvalidAccountNumberException e)
			{
				System.out.println(e);
			}
			catch(InsufficientBalanceException e)
			{
				System.out.println(e);
			}
			catch(NegativeAmountException e)
			{
				System.out.println(e);
			}
		}
		@Test
		public void transfer() throws InvalidAccountNumberException, InsufficientBalanceException, NegativeAmountException
		{
			try {
			assertEquals(5800,bankApplicationServerServicesImpl.fundTransfer(15,16 ,200),0.001);
		}
			catch(InvalidAccountNumberException e)
			{
				System.out.println(e);
			}
			catch(InsufficientBalanceException e)
			{
				System.out.println(e);
			}
			catch (SameAccountNumberException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			catch(NegativeAmountException e)
			{
				System.out.println(e);	
			}
		}
		@Test
		public void transfer1() throws InvalidAccountNumberException, InsufficientBalanceException, NegativeAmountException, SameAccountNumberException
		{
			try
			{
			assertEquals(4500,bankApplicationServerServicesImpl.fundTransfer(17,18 ,500),0.001);
		}
			catch(InvalidAccountNumberException e)
			{
				System.out.println(e);
			}
			catch(InsufficientBalanceException e)
			{
				System.out.println(e);
			}
			catch (SameAccountNumberException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			catch(NegativeAmountException e)
			{
				System.out.println(e);	
			}
		}
		


	}


