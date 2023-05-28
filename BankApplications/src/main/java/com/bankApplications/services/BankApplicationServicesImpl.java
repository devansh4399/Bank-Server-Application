package com.bankApplications.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.bankApplication.bean.Account;
import com.bankApplication.bean.Transactions;
import com.bankApplications.dao.BankApplicationsDao;
import com.bankApplications.dao.BankApplicationsDaoImpl;
import com.bankApplications.exceptions.InsufficientBalanceException;
import com.bankApplications.exceptions.InvalidAccountNumberException;
import com.bankApplications.exceptions.NegativeAmountException;
import com.bankApplications.exceptions.SameAccountNumberException;
import com.bankApplications.util.AccountUtil;

public class BankApplicationServicesImpl implements BankApplicationsServices
{
	BankApplicationsDao bankApplicationDaoImpl;
	public BankApplicationServicesImpl()
	{
		bankApplicationDaoImpl=new BankApplicationsDaoImpl();
	}

	public double deposit(int accountNumber, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException, NegativeAmountException 
	{
		Account account=bankApplicationDaoImpl.getById(accountNumber);
		if(account==null)
		{
			throw new InvalidAccountNumberException("Invalid Account Number");
		}
		if(amount<0)
		{
			throw new NegativeAmountException("Negative Amount");
		}
		int transactionId=new Random().nextInt(9999)+10000;
		ArrayList<Transactions> transactions=account.getTransactions();
		double balance=account.getBalance();
		account.setBalance(balance+amount);
		Transactions temp=new Transactions(transactionId,new Date(),"Credit",account.getBalance(),amount);
		transactions.add(temp);
	//	ArrayList<Transactions> tempTransaction=new ArrayList<Transactions>();
		account.setTransactions(transactions);
		
		return account.getBalance();
	}

	public double withdraw(int accountNumber, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException ,NegativeAmountException
	{
		Account account=bankApplicationDaoImpl.getById(accountNumber);
		if(account==null)
		{
			throw new InvalidAccountNumberException("Invalid Account Number");
		}
		if(amount<0)
		{
			throw new NegativeAmountException("Negative Amount");
		}
		if(account.getBalance()-amount<AccountUtil.MINIMUMBALANCE || account.getBalance()<amount)
		{
			throw new InsufficientBalanceException("Insufficient Balance in Account");
		}
		int transactionId=new Random().nextInt(9999)+10000;
		ArrayList<Transactions> transactions=account.getTransactions();
		double balance=account.getBalance();
		account.setBalance(balance-amount);
		ArrayList<Transactions> tempTransaction=new ArrayList<Transactions>();
		Transactions temp=new Transactions(transactionId,new Date(),"Debit",account.getBalance(),amount);
		
		transactions.add(temp);
		account.setTransactions(transactions);
		return account.getBalance();
	}

	public double fundTransfer(int accountNumberSender, int accountNumberReceiver, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException ,NegativeAmountException, SameAccountNumberException
	{
		if(accountNumberSender==accountNumberReceiver)
			throw new SameAccountNumberException("Same Account Number");
		if(amount<0)
		{
			throw new NegativeAmountException("Negative Amount");
		}
			Account senderAccount=bankApplicationDaoImpl.getById(accountNumberSender);
			Account receiverAccount=bankApplicationDaoImpl.getById(accountNumberReceiver);
			if(senderAccount==null || receiverAccount==null)
			{
				throw new InvalidAccountNumberException("Invalid Account Number");

			}
		double leftBalance=withdraw(accountNumberSender,amount);
		double recieverRemainingBalance=deposit(accountNumberReceiver,amount);
		return leftBalance;
	}

	public ArrayList<Transactions> showLastTransaction(int accountNumber) throws InvalidAccountNumberException 
	{
		
		Account account=bankApplicationDaoImpl.getById(accountNumber);
		if(account==null)
			throw new InvalidAccountNumberException("Please give porper account");
		ArrayList<Transactions> transactions=account.getTransactions();
		if(transactions.size()==0)
			System.out.println("No Transactions");

		return transactions;
	}

	public double showBalance(int accountNumber) throws InvalidAccountNumberException 
	{
		Account account=bankApplicationDaoImpl.getById(accountNumber);
		if(account==null)
			throw new InvalidAccountNumberException("Please give proper account");
		return account.getBalance();
		
	}

}
