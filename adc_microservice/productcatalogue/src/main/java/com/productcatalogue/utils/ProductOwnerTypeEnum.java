package com.productcatalogue.utils;

public enum ProductOwnerTypeEnum {
	EMPLOYEE(1L), PARTNER(2L), COMPETITOR(3L);
	
	 private final Long value;
	    private ProductOwnerTypeEnum(Long value) {
	        this.value = value;
	    }

	    public Long getValue() {
	        return value;
	    }
	
}
