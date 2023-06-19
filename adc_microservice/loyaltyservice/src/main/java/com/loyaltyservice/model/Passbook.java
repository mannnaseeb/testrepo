
package com.loyaltyservice.model;

import java.util.Date;

public class Passbook {

	private Long passbookId;
	private Customer customer;
	private Transaction transaction;
	private Long balance;
	private Date entryDate;
	
	public Long getPassbookId() {
		return passbookId;
	}
	public void setPassbookId(Long passbookId) {
		this.passbookId = passbookId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
	
	
}
