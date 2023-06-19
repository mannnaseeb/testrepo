package com.loyaltyservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.loyaltyservice.model.Coupon;
import com.loyaltyservice.model.Event;
import com.loyaltyservice.model.Redemptions;

@Mapper
public interface EventDao {

	/**
	 * 
	 * @param event
	 */
	public void createEvent(Event event);

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
	public List<Event> getEvent(@Param("eventId") Long eventId, @Param("eventName") String eventName, 
			@Param("eventTypeId") Long eventTypeId, @Param("ruleId") Long ruleId, @Param("campaignId") Long campaignId,
			@Param("limit") Long limit, @Param("offset") Long offset, @Param("orderBy") String orderBy);

	/**
	 * 
	 * @param coupon
	 */
	public void createCoupon(Coupon coupon);

	/**
	 * 
	 * @param couponId
	 * @param couponName
	 * @param eventTypeId
	 * @param ruleId
	 * @param campaignId
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 */
	public List<Coupon> getCoupon(@Param("couponId") Long couponId, @Param("couponName") String couponName, 
			@Param("eventTypeId") Long eventTypeId, @Param("ruleId") Long ruleId, @Param("campaignId") Long campaignId,
			@Param("limit") Long limit, @Param("offset") Long offset, @Param("orderBy") String orderBy);

	public void createRedeemption(Redemptions redemptions);
}
