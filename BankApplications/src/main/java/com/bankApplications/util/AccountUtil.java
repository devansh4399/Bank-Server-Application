package com.bankApplications.util;

import java.util.ArrayList;
import java.util.Date;

import com.bankApplication.bean.Account;
import com.bankApplication.bean.Customer;
import com.bankApplication.bean.Transactions;


public class AccountUtil 
{
	public final static int MINIMUMBALANCE=500;
	ArrayList<Account> accounts;
	public  ArrayList<Account> getAccount()
	 {
	 	return accounts;
	 }
	 public void setAccount(ArrayList<Account> accounts)
	 {
	 	this.accounts=accounts;
	 	
	 }
	 public AccountUtil()
	 {
		 accounts=new ArrayList<Account>();
		 ArrayList<Transactions> transaction1=new ArrayList<Transactions>();
		 ArrayList<Transactions> transaction2=new ArrayList<Transactions>();
	     ArrayList<Transactions> transaction3=new ArrayList<Transactions>();
		 ArrayList<Transactions> transaction4=new ArrayList<Transactions>();
         ArrayList<Transactions> transaction5=new ArrayList<Transactions>();
		 ArrayList<Transactions> transaction6=new ArrayList<Transactions>();
		 ArrayList<Transactions> transaction7=new ArrayList<Transactions>();
		 ArrayList<Transactions> transaction8=new ArrayList<Transactions>();
		 ArrayList<Transactions> transaction9=new ArrayList<Transactions>();
		 ArrayList<Transactions> transaction10=new ArrayList<Transactions>();
		 
		 accounts.add(new Account(11,1000,new Customer(1,"Aman","Kumar"),transaction1));
		 accounts.add(new Account(12,2000,new Customer(2,"Devansh","Srivastava"),transaction2));
		 accounts.add(new Account(13,5000,new Customer(3,"Vivek","Kumar"),transaction3));
		 accounts.add(new Account(14,4000,new Customer(4,"Asish","Kumar"),transaction4));
		 accounts.add(new Account(15,6000,new Customer(5,"Ankit","Kumar"),transaction5));
		 accounts.add(new Account(16,4000,new Customer(6,"Umang","Kumar"),transaction6));
		 accounts.add(new Account(17,5000,new Customer(7,"Nandani","Sinha"),transaction7));
		 accounts.add(new Account(18,10000,new Customer(8,"Preksha","Sinha"),transaction8));
		 accounts.add(new Account(19,5000,new Customer(9,"Pratik","Bhushan"),transaction9));
		 accounts.add(new Account(20,10000,new Customer(10,"Vishwas","Bhushan"),transaction10));
		 
	 }
	
}
