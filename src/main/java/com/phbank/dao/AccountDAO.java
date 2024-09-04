package com.phbank.dao;

import java.math.BigDecimal;

public class AccountDAO {
	
	private String acctNum;
	private BigDecimal balance;
	
	public String getAcctNum() {
		return acctNum;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	

}
