package com.loyaltyservice.service;

import java.util.List;

import com.loyaltyservice.model.Coupon;
import com.loyaltyservice.model.Event;
import com.loyaltyservice.model.Redemptions;

public interface EventService {
	
	/**
	 * 
	 * @param event
	 */
	void createEvent(Event event);
	
	/**
	 * 
	 * @param eventId
	 * @param eventName
	 * @param eventTypeId
	 * @param ruleId
	 * @param campaignId
	 * @param orderBy 
	 * @param offset 
	 * @param limit 
	 * @return
	 */
	List<Event> getEvent(Long eventId, String eventName, Long eventTypeId, Long ruleId, Long campaignId, Long limit, Long offset, String orderBy);
	
	/**
	 * 
	 * @param coupon
	 */
	void createCoupon(Coupon coupon);

	/**
	 * 
	 * @param couponId
	 * @param couponName
	 * @param eventTypeId
	 * @param ruleId
	 * @param campaignId
	 * @param orderBy 
	 * @param offset 
	 * @param limit 
	 * @return
	 */
	List<Coupon> getCoupon(Long couponId, String couponName, Long eventTypeId, Long ruleId, Long campaignId, Long limit, Long offset, String orderBy);

	void createRedeemption(Redemptions redemptions);
}
