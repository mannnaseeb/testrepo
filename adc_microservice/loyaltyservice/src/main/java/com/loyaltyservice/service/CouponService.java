package com.loyaltyservice.service;

import java.util.List;

import com.loyaltyservice.model.Coupon;

public interface CouponService {

	/**
	 * 
	 * @param coupon
	 */
	void createCoupon(Coupon coupon);

	List<Coupon> getCoupon(Long couponId, String couponName, Long eventTypeId, Long ruleId, Long campaignId, Long limit,
			Long offset, String orderBy);

}
