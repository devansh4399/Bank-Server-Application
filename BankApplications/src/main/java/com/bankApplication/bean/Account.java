package com.bankApplication.bean;

import java.util.ArrayList;

public class Account 
{
	private int accountNumber;
	private double balance;
	private Customer customer;
	private ArrayList<Transactions> transactions;
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", customer=" + customer
				+ ", transactions=" + transactions + "]";
	}
	public Account() {
		super();
	}
	public Account(int accountNumber, double balance, Customer customer, ArrayList<Transactions> transactions) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.customer = customer;
		this.transactions = transactions;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public ArrayList<Transactions> getTransactions() {
		return transactions;
	}
	public void setTransactions(ArrayList<Transactions> transactions) {
		this.transactions = transactions;
	}
}
