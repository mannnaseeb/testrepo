package com.loyaltyservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyaltyservice.dao.EventDao;
import com.loyaltyservice.model.Coupon;
import com.loyaltyservice.model.Event;
import com.loyaltyservice.model.Redemptions;
import com.loyaltyservice.service.EventService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EventServiceImpl implements EventService {
	/**
	 * 
	 */
	@Autowired
	private EventDao eventDao;

	@Override
	public void createEvent(Event event) {
		eventDao.createEvent(event);
	}

	@Override
	public List<Event> getEvent(Long eventId, String eventName, Long eventTypeId, Long ruleId, Long campaignId, Long limit, Long offset, String orderBy) {
		return eventDao.getEvent(eventId, eventName, eventTypeId, ruleId, campaignId, limit, offset, orderBy);
	}

	@Override
	public void createCoupon(Coupon coupon) {
		eventDao.createCoupon(coupon);
	}

	@Override
	public List<Coupon> getCoupon(Long couponId, String couponName, Long eventTypeId, Long ruleId, Long campaignId, Long limit, Long offset, String orderBy) {
		return eventDao.getCoupon(couponId, couponName, eventTypeId, ruleId, campaignId, limit, offset, orderBy);
	}

	@Override
	public void createRedeemption(Redemptions redemptions) {
		eventDao.createRedeemption(redemptions);
	}


}
