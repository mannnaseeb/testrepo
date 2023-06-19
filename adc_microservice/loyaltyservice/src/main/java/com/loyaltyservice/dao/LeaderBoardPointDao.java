package com.loyaltyservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.loyaltyservice.model.LeaderBoardPoint;
import com.loyaltyservice.model.Redemptions;
import com.loyaltyservice.model.Transaction;

@Mapper
public interface LeaderBoardPointDao {

	/**
	 * 
	 * @param partnerName
	 * @param rank
	 * @param transactionId
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @param sortType
	 * @return
	 */
	List<LeaderBoardPoint> getPartnerDetails(@Param("partnerName") String partnerName, @Param("rank") Integer rank, @Param("transactionId") String transactionId, 
			@Param("partnerId") Long limit,
			@Param("offset") Long offset, @Param("orderBy") String orderBy, @Param("sortType") String sortType);

	/**
	 * 
	 * @param customerId
	 * @param transactionId
	 * @return
	 */
	List<Transaction> getLeaderBoardPoints(@Param("customerId") Long customerId, @Param("transactionId") Long transactionId);

	List<Redemptions> getPartnerPoints(@Param("customerId") Long customerId, @Param("transactionId") Long transactionId);

}
