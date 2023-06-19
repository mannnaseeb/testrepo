package com.loyaltyservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.loyaltyservice.model.Transaction;

@Mapper
public interface TransactionDao {
	/**
	 * 
	 * @param transaction
	 */
	public void createTransaction( Transaction transaction);
	/**
	 * 
	 * @param customerId
	 * @return
	 */
	public List<Transaction> getTransaction(@Param("transactionId") Long transactionId, @Param("customerId") Long customerId, 
			@Param("eventId") Long eventId, @Param("limit") Long limit, @Param("offset") Long offset, @Param("orderBy") String orderBy);


	/**
	 * 
	 * @param transactionId
	 * @return
	 */
	public Long getTransactionCount(@Param("transactionId") Long transactionId,
			@Param("customerId") Long customerId, @Param("eventId") Long eventId);
	
}
