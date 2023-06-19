package com.loyaltyservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyaltyservice.dao.TransactionDao;
import com.loyaltyservice.model.Passbook;
import com.loyaltyservice.model.Transaction;
import com.loyaltyservice.service.LoyaltyRuleService;
import com.loyaltyservice.service.PassbookService;
import com.loyaltyservice.service.TransactionService;

@Service
public class TransactionServiceimpl implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private PassbookService passbookService;

	@Autowired
	private LoyaltyRuleService loyaltyRuleService;

	@Override
	public void createTransaction(Transaction transaction) {
		//Start Run loyalty rule
		/*
		 * Transaction transactionRule = loyaltyRuleService.loyaltyRule(transaction);
		 * if(null != transactionRule && transactionRule.getPoint() < Long.valueOf(0)) {
		 * return; }
		 */
		//End loyalty rule
		transactionDao.createTransaction(transaction);
		Transaction lastTransaction = null;
		/**Get last transaction**/
		List<Transaction> transactions = transactionDao.getTransaction(null, transaction.getCustomer().getCustomerId(), null, 1L, null, "transactionId");
		if(null != transactions && !transactions.isEmpty()) {
			lastTransaction = transactions.get(0);
			List<Passbook> passbooks = passbookService.getPassbook(String.valueOf(transaction.getCustomer().getCustomerId()), null, 1L, null, "passbookId", "desc");
			Passbook lastPassbook = null;
			if(null != passbooks && !passbooks.isEmpty()) {
				lastPassbook = passbooks.get(0);
			}

			Long balance = 0l;
			if(null!=lastPassbook ) {
				balance = lastTransaction.getPoint()+lastPassbook.getBalance();
			}else {
				balance=lastTransaction.getPoint();
			}

			Passbook newPassbookEntry = new Passbook();
			newPassbookEntry.setCustomer(transaction.getCustomer());
			newPassbookEntry.setTransaction(transaction);
			newPassbookEntry.setBalance(balance);
			newPassbookEntry.setTransaction(lastTransaction);
			passbookService.createPassbook(newPassbookEntry);

		}
	}

	@Override
	public List<Transaction> getTransaction(Long transactionId, Long customerId, Long eventId, Long limit, Long offset,
			String orderBy) {
		return transactionDao.getTransaction(transactionId, customerId, eventId, limit, offset, orderBy);
	}
	
	@Override
	public Long getTransactionCount(Long transactionId, Long customerId, Long eventId) {
		return transactionDao.getTransactionCount(transactionId,
				customerId, eventId);
	}
}
