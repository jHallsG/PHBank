package com.phbank.dto;

import java.math.BigInteger;

import org.springframework.security.core.context.SecurityContextHolder;

public class DepositDTO {
	
	private String acctNum;
	private BigInteger  amount;
	
	public DepositDTO() {
        this.acctNum = SecurityContextHolder.getContext().getAuthentication().getName();
    }
	
	public String getAcctNum() {
		return acctNum;
	}
	public BigInteger getAmount() {
		return amount;
	}
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}

}
