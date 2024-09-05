package com.phbank.dao;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CredentialsDAO implements UserDetails{
	
	private String password;
	private String acctNum;
	private String role;
	private CustomerDAO custDao;
	
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
	public CustomerDAO getCustDao() {
		return custDao;
	}
	public void setCustDao(CustomerDAO custDao) {
		this.custDao = custDao;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority(role));
	}
	@Override
	public String getUsername() {
		return acctNum;
	}
}
