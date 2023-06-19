package com.loyaltyservice.constant;

public interface UrlConstant {

	public interface Basic {
		String BASE_URL = "/api/v1/loyalty";
	}
	
	interface Header {
		String AUTH = "Auth";
		String CLIENT_ID = "client_id";
		String CLIENT_SECRET = "client_secret";
		String BASIC = "Basic ";
		String AUTHORIZATION = "Authorization";
	}

	public interface URL {

		// --------------------------- COUPON CONTSANT ---------------------------
		String CREATE_COUPON = "/coupon/add";
		String GET_COUPON = "/coupon";
		String CREATE_REDEEM_REQUEST = "/redeem/request";
		
		// ------------------------- TRANSACTION CONTSANT ------------------------
		String CREATE_TRANSACTION = "/transaction";
		String GET_TRANSACTION = "/transactions";
		String GET_PASSBOOK_BY_CUSTOMERID = "/passbook/{customerId}";
		
		// ----------------------------- TASK CONTSANT ---------------------------
		String CREATE_TASK = "/task/add";
		String GET_TASK = "/task";
		String GET_PASSBOOK = "/passbook";
		String CREATE_EVENT = "/event/add";
		String GET_EVENT = "/event";
		
		String GET_LEADER_BOARD_POINT = "/leaderboardpoints";
		String GET_POINT_REDEMPTION_POINT = "/pointsredeem";

		interface Header {
			String AUTHORIZATION = "Auth";
		}
	}
}
