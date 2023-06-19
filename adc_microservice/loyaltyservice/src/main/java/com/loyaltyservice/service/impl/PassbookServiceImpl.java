package com.loyaltyservice.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyaltyservice.dao.PassbookDao;
import com.loyaltyservice.model.Passbook;
import com.loyaltyservice.service.PassbookService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PassbookServiceImpl implements PassbookService {
	private static final Logger log = LoggerFactory.getLogger(PassbookServiceImpl.class);
	
	@Autowired
	private PassbookDao passbookDao;

	@Override
	public List<Passbook> getPassbook(String customerId, String transactionId, Long limit, Long offset, String orderBy, String sortType) {
		
		log.info("PassbookServiceImpl-> [getPassbook] customerId :: {} and transactionId :: {} and limit :: {} "
				+ "and offset :: {} and orderBy :: {} and sortType :: {}", customerId,
				transactionId,limit,offset,orderBy,sortType);
		return passbookDao.getPassbook(customerId, transactionId, limit, offset, orderBy, sortType);
	}

	@Override
	public void createPassbook(Passbook newPassbookEntry) {
		passbookDao.createPassbook(newPassbookEntry);
	}

	@Override
	public Long getPassbookCount(String customerId, String transactionId) {
		return passbookDao.getPassbookCount(customerId, transactionId);
	}

}
