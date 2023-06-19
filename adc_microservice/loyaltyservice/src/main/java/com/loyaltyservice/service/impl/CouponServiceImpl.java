package com.loyaltyservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyaltyservice.dao.CouponDao;
import com.loyaltyservice.model.Coupon;
import com.loyaltyservice.service.CouponService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CouponServiceImpl implements CouponService{
	
	@Autowired
	private CouponDao couponDao;

	/**
	 * 
	 */
	@Override
	public void createCoupon(Coupon coupon) {
		couponDao.createCoupon(coupon);
		
	}

	@Override
	public List<Coupon> getCoupon(Long couponId, String couponName, Long eventTypeId, Long ruleId, Long campaignId,
			Long limit, Long offset, String orderBy) {
		return couponDao.getCoupon(couponId, couponName, eventTypeId, ruleId, campaignId,
				limit, offset, orderBy);
	}

}
