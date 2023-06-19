package com.loyaltyservice.enumeration;

public enum EventType {

	EARN(101), REDEEM(102), ADJUST(103);

	private final int value;

	private EventType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "RewardType{" + "value=" + value + '}';
	}
}
