package com.bankApplications.dao;

import java.util.ArrayList;
import java.util.Iterator;

import com.bankApplication.bean.Account;
import com.bankApplications.util.AccountUtil;


public class BankApplicationsDaoImpl implements BankApplicationsDao
{
	AccountUtil accountUtil;
	public BankApplicationsDaoImpl()
	{
		accountUtil=new AccountUtil();
	}
	public Account getById(int accountNumber) 
	{
		
		
		ArrayList<Account> accounts=new ArrayList<Account>();
		accounts=accountUtil.getAccount();
	
		for(int i=0;i<accounts.size();i++)
		{
			if(accounts.get(i).getAccountNumber()==accountNumber)
				return accounts.get(i);
			
		}
		return null;
	}

}
