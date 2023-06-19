package com.loyaltyservice.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.loyaltyservice.model.LeaderBoardPoint;
import com.loyaltyservice.model.ResponseBean;

public interface LeaderBoardPointService {

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
	List<LeaderBoardPoint> getPartnerDetails(String partnerName, Integer rank, String transactionId, Long limit,
			Long offset, String orderBy, String sortType);


	/**
	 *
	 */
	ResponseEntity<ResponseBean> getPointsRedemption(String partnerServiceURL, Long customerId,Long transactionId);


	ResponseEntity<ResponseBean> getPartners(String authorization, String partnerServiceURL, Long customerId, Long partnerIds, Long transactionId);

}
