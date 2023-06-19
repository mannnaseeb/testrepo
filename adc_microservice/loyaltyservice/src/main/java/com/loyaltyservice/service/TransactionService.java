package com.loyaltyservice.service;

import java.util.List;

import com.loyaltyservice.model.Transaction;

public interface TransactionService {
	/**
	 * 
	 * @param transaction
	 */
	void createTransaction(Transaction transaction);
	/**
	 * 
	 * @param customerId
	 * @param orderBy 
	 * @param offset 
	 * @param limit 
	 * @param eventId 
	 * @param customerId2 
	 * @return
	 */
	List<Transaction> getTransaction(Long transactionId, Long customerId, Long eventId, Long limit, Long offset, String orderBy);
	
	/**
	 * 
	 * @param transactionId
	 * @param customerId 
	 * @param eventId 
	 * @return
	 */
	Long getTransactionCount(Long transactionId, Long customerId, Long eventId); 

}
