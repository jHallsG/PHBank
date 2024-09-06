package com.phbank.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import com.phbank.dao.impl.ServicesDAOImpl;
import com.phbank.model.TransactionsModel;

@Service
public class BankServiceImpl {
	
	private ServicesDAOImpl services;
	
	public BankServiceImpl(ServicesDAOImpl services) {
		this.services = services;
	}
	
	public BigInteger getBalance(String acctNum) {
		return services.viewBalance(acctNum);
	}
	
	public void editInfo(String acctNum, String name, String address, String contact) {
		services.editAccount(acctNum, name, address, contact);
	}
	
	public List<TransactionsModel> getTransactions(String acctNum) {
		return services.viewTransactions(acctNum);
	}
	
	public void deposit(BigInteger amt, String acctNum) {
		services.deposit(amt, acctNum);
	}
}
