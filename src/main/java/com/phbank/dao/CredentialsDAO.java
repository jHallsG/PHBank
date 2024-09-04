package com.phbank.dao;

public class CredentialsDAO {
	
	private String password;
	private String acctNum;
	private String role;
	
	public String getPassword() {
		return password;
	}
	public String getAcctNum() {
		return acctNum;
	}
	public String getRole() {
		return role;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
