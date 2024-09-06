package com.phbank.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phbank.dao.ServicesDAO;
import com.phbank.model.AccountModel;
import com.phbank.model.TransactionsModel;

@Repository
public class ServicesDAOImpl implements ServicesDAO{
	
	private final JdbcTemplate jdbcTemplate;
	
	private final String currentBalance = "SELECT balance FROM account WHERE account_number = ?";
	private final String viewTransaction = "SELECT transaction_type as type, amount, transaction_date as transactionDate FROM transaction WHERE account_number = ?";
	private final String updateCustomerInfo = "UPDATE customer SET name = ?, address = ?, contact_number = ? WHERE account_number = ?";
	private final String updateCustomerInfoTransaction = "INSERT INTO transaction (account_number,transaction_type) VALUES (?,?)";
	private final String deposit = "UPDATE account SET balance = balance + ? WHERE account_number = ?";
	private final String depositTransaction = "INSERT INTO transaction (account_number,transaction_type, amount) VALUES (?,?,?)";
	
	
	
	public ServicesDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional
	@Override
	public void editAccount(String acctNum, String name, String address, String contact) {
		jdbcTemplate.update(updateCustomerInfo, name, address, contact, acctNum);
		jdbcTemplate.update(updateCustomerInfoTransaction, acctNum,"edit_profile");
	}

	@Transactional
	@Override
	public void deposit(BigInteger amount, String acctNum) {
		jdbcTemplate.update(deposit, amount, acctNum);
		jdbcTemplate.update(depositTransaction, acctNum, "deposit", amount);
	}

	@Override
	public void transfer() {
		String sqlQueryForSender = "UPDATE account SET balance = balance - ? WHERE account_number = ?";
		String sqlQueryForReceiver = "UPDATE account SET balance = balance + ? WHERE account_number = ?";
		String transactionRecordForSender = "INSERT INTO transaction (account_number, transaction_type, amount) VALUES (?,?,?)";
		String transactionRecordForReceiver = "INSERT INTO transaction (account_number, transaction_type, amount) VALUES (?,?,?)";
	}

	@Transactional(readOnly = true)
	@Override
	public List<TransactionsModel> viewTransactions(String acctNum) {
		List<TransactionsModel> transactions = jdbcTemplate.query(viewTransaction, new BeanPropertyRowMapper<>(TransactionsModel.class), acctNum);
		
		return transactions;
	}

	@Transactional(readOnly = true)
	@Override
	public BigInteger viewBalance(String acctNum) {
		return jdbcTemplate.queryForObject(currentBalance, BigInteger.class, acctNum);
	}
}
