package com.loyaltyservice.service;

import java.util.List;

import com.loyaltyservice.model.Passbook;


public interface PassbookService {
	/**
	 * 
	 * @param customerId
	 * @param transactionId
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 */
	List<Passbook> getPassbook(String customerId, String transactionId, Long limit, Long offset, String orderBy, String sortType);
	/**
	 * 
	 * @param newPassbookEntry
	 */
	void createPassbook(Passbook newPassbookEntry);
	
	/**
	 * 
	 * @param transactionId
	 * @param customerId 
	 * @return
	 */
	Long getPassbookCount(String customerId, String transactionId); 

}
