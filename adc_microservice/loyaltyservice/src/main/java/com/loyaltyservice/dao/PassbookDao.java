package com.loyaltyservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.loyaltyservice.model.Passbook;

@Mapper
public interface PassbookDao {

	void createPassbook(Passbook passbook);

	/**
	 * 
	 * @param customerId
	 * @param transactionId
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 */
	List<Passbook> getPassbook(@Param("customerId") String customerId, @Param("transactionId") String transactionId,
			@Param("limit") Long limit, @Param("offset") Long offset, @Param("orderBy") String orderBy, @Param("sortType") String sortType);
	
	/**
	 * 
	 * @param customerId
	 * @param transactionId
	 * @return
	 */
	public Long getPassbookCount(@Param("customerId") String customerId, @Param("transactionId") String transactionId);
}
