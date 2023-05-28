package com.bankApplications.clients;

import java.util.ArrayList;
import java.util.Scanner;

import com.bankApplication.bean.Transactions;
import com.bankApplications.exceptions.InsufficientBalanceException;
import com.bankApplications.exceptions.InvalidAccountNumberException;
import com.bankApplications.exceptions.NegativeAmountException;
import com.bankApplications.exceptions.SameAccountNumberException;
import com.bankApplications.services.BankApplicationServicesImpl;
import com.bankApplications.services.BankApplicationsServices;

public class Main {
	BankApplicationsServices bankApplicationServices;
	
	public Main()
	{
		bankApplicationServices=new BankApplicationServicesImpl();
	}
	public static void main(String[] args) 
	{
		Main mainObj=new Main();
		boolean exit=false;
		while(exit==false)
		{
			System.out.println("Enter 1 for Withdraw");
			System.out.println("Enter 2 for deposit");
			System.out.println("Enter 3 for transfer");
			System.out.println("Enter 4 for last ten transactions");
			System.out.println("Enter 5 for show balance");
			System.out.println("Enter 6 for Exit");
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			switch(n)
			   {
			   case 1:
			   
				try
				{
					double amountAfterWithdraw,amountAfterDeposit,amountAfterTransfer;
					System.out.println("Enter Account Number");
					int accountNo=sc.nextInt();
					System.out.println("Enter Amount to withdraw ");
					int amount=sc.nextInt();
				 amountAfterWithdraw=mainObj.bankApplicationServices.withdraw(accountNo, amount);
				System.out.println("Amount After Withdraw="+amountAfterWithdraw);
				}
				catch(InvalidAccountNumberException e)
				{
					System.out.println(e);
				}
				catch( InsufficientBalanceException f)
				{
					System.out.println(f);
				}
				catch(NegativeAmountException e)
				{
					System.out.println(e);
				}
				break;
				
			   case 2:
					try
					{
						double amountAfterWithdraw,amountAfterDeposit,amountAfterTransfer;
						System.out.println("Enter Account Number");
						int accountNo=sc.nextInt();
						System.out.println("Enter Amount to deposit ");
						int amount=sc.nextInt();
					 amountAfterDeposit=mainObj.bankApplicationServices.deposit(accountNo, amount);
					System.out.println("Amount After Deposit="+amountAfterDeposit);
					}
					catch(InvalidAccountNumberException e)
					{
						System.out.println(e);
					}
					catch(NegativeAmountException e)
					{
						System.out.println(e);
					} catch (InsufficientBalanceException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
					break;
			   case 3:
					try
					{
						double amountAfterWithdraw,amountAfterDeposit,amountAfterTransfer;
						System.out.println("Enter your Account Number ");
						int accountNo1=sc.nextInt();
						System.out.println("Enter your Account Number to send the money ");
						int accountNo2=sc.nextInt();
						System.out.println("Enter Amount to trasnfer");
						int amount=sc.nextInt();
					 amountAfterTransfer=mainObj.bankApplicationServices.fundTransfer(accountNo1,accountNo2,amount);
					System.out.println("Amount After Transfer="+amountAfterTransfer);
					}
					catch(InvalidAccountNumberException e)
					{
						System.out.println(e);
					}
					catch( InsufficientBalanceException f)
					{
						System.out.println(f);
					}
					catch(NegativeAmountException e)
					{
						System.out.println(e);
					}
					catch(SameAccountNumberException e)
		   			{
		   				System.out.println(e);
		   			}
					break;
			   case 4:
					  ArrayList<Transactions>transactions;
					   try
					   {
						 System.out.println("Enter account Number");
						  int accountNo=sc.nextInt();
						  transactions=mainObj.bankApplicationServices.showLastTransaction(accountNo);
						  for(int i=0;i<transactions.size();i++)
						  {
							  System.out.println(transactions.get(i));
						  }
					   }
						  
					   	catch(InvalidAccountNumberException e)
					   {
						   System.out.println("Unsuccessful");
						   System.out.println(e);
					   }
					   
			
					   		break;
			   case 5:
		   			try
		   			{
		   				System.out.println("Enter account number");
		   				int accountNo=sc.nextInt();
		   				double balance=mainObj.bankApplicationServices.showBalance(accountNo);
		   				System.out.println("your balance"+balance);
		   			}
		   			catch(InvalidAccountNumberException e)
		   			{
		   				System.out.println(e);
		   			}
		   			
		   			break;
		   			
				  case 6:exit=true;
		
			   
	}

		}
	}
}
