package com.bankApplications.services;

import java.util.ArrayList;

import com.bankApplication.bean.Transactions;
import com.bankApplications.exceptions.InsufficientBalanceException;
import com.bankApplications.exceptions.InvalidAccountNumberException;
import com.bankApplications.exceptions.NegativeAmountException;
import com.bankApplications.exceptions.SameAccountNumberException;



public interface BankApplicationsServices 
{
	double deposit(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException, NegativeAmountException;
	double withdraw(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException, NegativeAmountException;
	double fundTransfer(int accountNumberSender,int accountNumberReceiver,int amount) throws InvalidAccountNumberException, InsufficientBalanceException, NegativeAmountException, SameAccountNumberException;
	ArrayList<Transactions> showLastTransaction(int accountNumber) throws InvalidAccountNumberException;
	double showBalance(int accountNumber) throws InvalidAccountNumberException;
}
