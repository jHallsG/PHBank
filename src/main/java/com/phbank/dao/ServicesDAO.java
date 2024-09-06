package com.phbank.dao;

import java.math.BigInteger;
import java.util.List;

import com.phbank.model.TransactionsModel;

public interface ServicesDAO {
	
	public BigInteger viewBalance(String acctNum);
	public void editAccount(String acctNum, String name, String address, String contact);
	public void deposit(BigInteger amt, String acctNum);
	public void transfer();
	public List<TransactionsModel> viewTransactions(String acctNum);
}
