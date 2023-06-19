package com.loyaltyservice.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.loyaltyservice.dao.LeaderBoardPointDao;
import com.loyaltyservice.model.LeaderBoardPoint;
import com.loyaltyservice.model.LeaderPointsResponse;
import com.loyaltyservice.model.RedemptionResponse;
import com.loyaltyservice.model.Redemptions;
import com.loyaltyservice.model.ResponseBean;
import com.loyaltyservice.model.Transaction;
import com.loyaltyservice.model.response.PartnerData;
import com.loyaltyservice.model.response.PartnerDetailResponse;
import com.loyaltyservice.service.LeaderBoardPointService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LeaderBoardServiceImpl implements LeaderBoardPointService {

	@Autowired
	private LeaderBoardPointDao leaderBoardPointDao;

	@Autowired
	private RestTemplate restTemplate;

	LeaderBoardPoint leaderBoardPoint = null;
	
	List<Transaction> transactions = null;

	@Override
	public List<LeaderBoardPoint> getPartnerDetails(String partnerName, Integer rank, String transactionId, Long limit,
			Long offset, String orderBy, String sortType) {
		return leaderBoardPointDao.getPartnerDetails(partnerName, rank, transactionId, limit, offset, orderBy,
				sortType);
	}

	/**
	 * 
	 */
	@Override
	public ResponseEntity<ResponseBean> getPartners(String authorization, String partnerServiceURL, Long customerId,
			Long partnerIds, Long transactionId) {

		String partnerId = Long.toString(partnerIds);
		ResponseEntity<ResponseBean> responseEntity = null;
		ResponseBean responseBean = new ResponseBean();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", authorization);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> httpEntity = new HttpEntity<String>(headers);

		List<PartnerData> partnerdataList = new ArrayList<PartnerData>();
		List<LeaderPointsResponse> leaderPointsResponsesList = new ArrayList<LeaderPointsResponse>();

		String partners = partnerServiceURL.replace("?partnerIds={partnerIds}", "?partnerIds=")
				.concat(partnerId);

		ResponseEntity<PartnerDetailResponse> leaderBoardPointResponse = restTemplate.exchange(partners,
				HttpMethod.GET, httpEntity, PartnerDetailResponse.class);

		log.info("LeaderBoardServiceImpl-> [getPartners] :::: Partners" + leaderBoardPointResponse);

		if (leaderBoardPointResponse.getStatusCode().is2xxSuccessful()) {
			PartnerDetailResponse partnerDetailResponse = leaderBoardPointResponse.getBody();
			partnerdataList = partnerDetailResponse.getData();
			for (PartnerData partnerData : partnerdataList) {
				LeaderPointsResponse leaderPointsResponse = new LeaderPointsResponse();
				leaderPointsResponse.setPartnerName(partnerData.getPartnerName());
				List<Transaction> points = getLeaderBoardPoints(customerId, transactionId);
				for (Transaction transaction : points) {
					leaderPointsResponse.setPoints(transaction.getPoint());
				}
				leaderPointsResponsesList.add(leaderPointsResponse);
				System.out.println("parnter name" + partnerData.getPartnerName());
			}
			responseBean.setData(leaderPointsResponsesList);
			responseBean.setStatus("SUCCESS");
			responseBean.setStatusCode("200");
			ResponseEntity.ok(responseBean);
		} else {
			responseBean.setData(leaderPointsResponsesList);
			responseBean.setStatus("FAILED");
			responseBean.setStatusCode("404");
			ResponseEntity.badRequest().body(responseBean);
		}

		return responseEntity;
	}

	private List<Transaction> getLeaderBoardPoints(Long customerId, Long transactionId) {
		return leaderBoardPointDao.getLeaderBoardPoints(customerId, transactionId);

	}

	/**
	 * 
	 */
	@Override
	public ResponseEntity<ResponseBean> getPointsRedemption(String partnerServiceURL, Long customerId,
			Long transactionId) {

		ResponseEntity<ResponseBean> responseEntity = null;
		ResponseBean responseBean = new ResponseBean();
		HttpHeaders headers = new HttpHeaders();
		// headers.set("Authorization", authorization);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		Redemptions redemptions = new Redemptions();
		// redemptions.setPartnerIds(partnerIds);
		HttpEntity<Redemptions> entity = new HttpEntity<Redemptions>(redemptions, headers);

		List<Redemptions> redemptionList = new ArrayList<Redemptions>();
		List<RedemptionResponse> redemptionResp = new ArrayList<RedemptionResponse>();

		ResponseEntity<Redemptions[]> leaderResponseEntity = restTemplate.exchange(partnerServiceURL, HttpMethod.GET,
				entity, Redemptions[].class);

		if (leaderResponseEntity.getStatusCode().is2xxSuccessful()) {
			Redemptions[] redemption = leaderResponseEntity.getBody();
			redemptionList = new ArrayList<Redemptions>(Arrays.asList(redemption));
			for (Redemptions redeem : redemptionList) {
				RedemptionResponse redemptionResponse = new RedemptionResponse();
				redemptionResponse.setPartnerName(leaderBoardPoint.getPartnerName());
				List<Redemptions> redempList = getPartnerPoints(customerId, transactionId);
				for (Redemptions redeemPoints : redempList) {
					redemptionResponse.setPointsRedeem(redeemPoints.getTransaction().getPoint());
				}
				redemptionResp.add(redemptionResponse);
			}
			responseBean.setData(redemptionResp);
			responseBean.setStatus("SUCCESS");
			responseBean.setStatusCode("200");
			ResponseEntity.ok(responseBean);
		} else {
			responseBean.setData(redemptionResp);
			responseBean.setStatus("FAILED");
			responseBean.setStatusCode("404");
			ResponseEntity.badRequest().body(responseBean);
		}

		return responseEntity;

	}

	private List<Redemptions> getPartnerPoints(Long customerId, Long transactionId) {
		return leaderBoardPointDao.getPartnerPoints(customerId, transactionId);
	}

}
