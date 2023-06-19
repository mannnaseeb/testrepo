package com.loyaltyservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.loyaltyservice.model.Coupon;

@Mapper
public interface CouponDao {

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
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 */
	List<Coupon> getCoupon(Long couponId, String couponName, Long eventTypeId, Long ruleId, Long campaignId, Long limit,
			Long offset, String orderBy);

}
