package com.moneysupermarket.domain;

public enum Taste {
	BITTER(1),SOUR(2),SWEET(3),TOOSWEET(4);
	
	private final int value;

	Taste(int value) {
		this.value = value;
	}
	
	public int getValue() {
        return value;
    }
}
