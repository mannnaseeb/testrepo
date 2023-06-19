package com.productcatalogue.utils;

import static com.productcatalogue.utils.MessageConstant.MessageKey.*;
import java.util.HashMap;
import java.util.Map;

public class MessageConstant {

	public static Map<String, Object> message = new HashMap<>();
	public static Map<String, Object> messageCode = new HashMap<>();

	public interface Status {
		int BAD_REQUEST = 400;
		int SUCCESS_STATUS = 200;
		int DATA_NOT_FOUND_STATUS= 404;

	}

	public interface MessageKey {

		// ----- message key ------
		String SUCCESS_MESSAGE = "SUCCESS";
		String BLANK_FIELD_ID = "blank id";
		
		String INVALID_ID = "Invalid id";
		String INVALID_NAME = "Invalid name";
		String DEACTIVATE_MESSAGE = "Deactivate data";
		String UPDATED_MESSAGE = "update data";
		String NOT_EXIST = "Invalid partner";
		String NOT_USER_FOUND = "Invalid active user";
		String NAME_CHECKIN = "Invalid name";
		String BLANK_NAME = "blank name";
		String BLANK_CAPTION = "blank caption";
		String BLANK_CREATED_BY = "blank created by";
		String BLANK_MODIFIED_BY = "blank modified by";
		String BLANK_SHORT_DESCRIPTION = "blank short description";
		String BLANK_LONG_DESCRIPTION = "blank long description";
		

		// PRODUCT CONSTANT
		String BLANK_PRODUCT_ID = "blank product id";
		String BLANK_PRODUCT_NAME = "blank product name";
		String INAVLID_PRODUCT_ID = "invalid product id";
		String INAVLID_PRODUCT_NAME = "invalid product name";

		// PARTNER CONSTANT
		String BLANK_PARTNER_ID = "blank partner id";
		String BLANK_PARTNER_NAME = "blank partner name";
		String INAVLID_PARTNER_ID = "invalid partner id";
		String INAVLID_PARTNER_NAME = "invalid partner name";

		// LOCATION CONTANT
		String INAVLID_LOCATION_ID = "invalid location id";
		String INAVLID_REGION_ID = "invalid region id";
		String INAVLID_COUNTRY_ID = "invalid country id";
		String INAVLID_CAMPUS_ID = "invalid metro id";
		String INAVLID_METRO_ID = "invalid campus id";
		String BLANK_FIELD_LOCATION_ID = "blank location id";
		String BLANK_FIELD_REGION_ID = "blank region id";
		String BLANK_FIELD_COUNTRY_ID = "blank country id";
		String BLANK_FIELD_METRO_ID = "blank metro id";
		String BLANK_FIELD_CAMPUS_ID = "blank campus id";

		// FAMILY CONSTANT
		String INAVLID_FAMILY_ID = "invalid family id";
		String INAVLID_FAMILY_NAME = "invalid product name";
		String BLANK_FAMILY_ID = "blank family id";
		String BLANK_FAMILY_NAME = "blank family name";

		// OWNERTYPE_ID CONSTANT
		String INAVLID_PRODUCT_OWNERTYPE_ID = "invalid product ownertype id";
		
		String FETCH_DATA = "Data Fetched";
		String DATA_NOT_FOUND = "No data found";
	}

	static {

		// ---- messages -------
		
		message.put(BLANK_FIELD_ID, "Please enter the partner id"); // blank id
		
		message.put(INVALID_ID, "Please enter the correct partner id"); // invalid id
		
		message.put(DEACTIVATE_MESSAGE, "Successfully deleted"); // deactivate data
		message.put(UPDATED_MESSAGE, "Successfully updated"); // updated data
		message.put(NOT_EXIST, "Id not exist"); // invalid id
		message.put(INVALID_NAME, "Invalid name"); // invalid name
		message.put(NOT_USER_FOUND, "No user found"); // invalid name
		message.put(NAME_CHECKIN, "Name is already exsit. Please use different name"); // invalid name
		message.put(BLANK_NAME, "Please enter the product name"); // invalid name
		message.put(BLANK_CAPTION, "Caption can not be blank"); // blank caption
		message.put(BLANK_CREATED_BY, "Created by can not be blank"); // blank created by
		message.put(BLANK_MODIFIED_BY, "Modified by can not be blank"); // blank modified by
		message.put(BLANK_SHORT_DESCRIPTION, "Short desc can not be blank"); // "blank short description
		message.put(BLANK_LONG_DESCRIPTION, "Long desc can not be blank"); // blank long description

		// PRODUCT CONSTANT
		message.put(BLANK_PRODUCT_ID, "Please enter the product id"); // product id
		message.put(BLANK_PRODUCT_NAME, "Please enter the product name"); // product name
		message.put(INAVLID_PRODUCT_ID, "Please enter the correct product id"); // invalid id
		message.put(INAVLID_PRODUCT_NAME, "Please enter the correct product name"); // invalid name

		// PARTNER CONSTANT
		message.put(BLANK_PARTNER_ID, "Please enter the partner id"); // partner id
		message.put(BLANK_PARTNER_NAME, "Please enter the partner name"); // partner name
		message.put(INAVLID_PARTNER_ID, "Please enter the correct partner id"); // invalid id
		message.put(INAVLID_PRODUCT_NAME, "Please enter the correct partner name"); // invalid name   
		message.put(INAVLID_PARTNER_NAME, "Please enter correct partner name");

		// LOCATION CONTANT
		message.put(INAVLID_LOCATION_ID, "Please enter the correct location id"); // invalid name
		message.put(BLANK_FIELD_LOCATION_ID, "Please enter the region id"); // blank id
		message.put(BLANK_FIELD_REGION_ID, "Please enter the region id"); // blank id
		message.put(BLANK_FIELD_COUNTRY_ID, "Please enter the country id"); // blank id
		message.put(BLANK_FIELD_METRO_ID, "Please enter the metro id"); // blank id
		message.put(BLANK_FIELD_CAMPUS_ID, "Please enter the campus id"); // blank id
		
		message.put(INAVLID_REGION_ID, "Please enter the correct region region id"); // invalid id
		message.put(INAVLID_COUNTRY_ID, "Please enter the correct country id"); // invalid id
		message.put(INAVLID_CAMPUS_ID, "Please enter the correct campus metro id"); // invalid id
		message.put(INAVLID_METRO_ID, "Please enter the correct campus id"); // invalid id

		// FAMILY CONSTANT
		message.put(INAVLID_FAMILY_ID, "Please enter the correct family id"); // invalid name 
		message.put(INAVLID_FAMILY_NAME, "Please enter the correct family name");
		message.put(BLANK_FAMILY_ID, "Please enter the family id");
		message.put(BLANK_FAMILY_NAME, "Please enter the family name");
		
		// OWNERTYPE_ID CONSTANT
		message.put(INAVLID_PRODUCT_OWNERTYPE_ID, "Invalid ownertype id"); // invalid name
		
		message.put(FETCH_DATA, "Data fetch successfully"); // Fetch success
		message.put(DATA_NOT_FOUND, "Data not found"); // blank data
		message.put(SUCCESS_MESSAGE, "Successfully save data"); // Success
		
		

		// ---- message code ------
		messageCode.put(SUCCESS_MESSAGE, 1);
		messageCode.put(BLANK_FIELD_ID, 3);
		messageCode.put(INVALID_ID, 4);
		
		
		messageCode.put(DEACTIVATE_MESSAGE, 7);
		messageCode.put(UPDATED_MESSAGE, 8);
		messageCode.put(NOT_EXIST, 9);
		messageCode.put(NOT_USER_FOUND, 10);
		messageCode.put(NAME_CHECKIN, 11);
		messageCode.put(BLANK_NAME, 12);
		messageCode.put(BLANK_CAPTION, 13);
		messageCode.put(BLANK_CREATED_BY, 14);
		messageCode.put(BLANK_MODIFIED_BY, 15);
		messageCode.put(BLANK_SHORT_DESCRIPTION, 16);
		messageCode.put(BLANK_LONG_DESCRIPTION, 17);
		
		
		messageCode.put(DATA_NOT_FOUND, 6);
		messageCode.put(FETCH_DATA, 5);
		
		// PRODUCT CONSTANT
		messageCode.put(BLANK_PRODUCT_ID, 18);
		messageCode.put(BLANK_PRODUCT_NAME, 19);
		messageCode.put(INAVLID_PRODUCT_ID, 20);
		messageCode.put(INAVLID_PRODUCT_NAME, 21);

		// PARTNER CONSTANT
		messageCode.put(BLANK_PARTNER_ID, 22);
		messageCode.put(BLANK_PARTNER_NAME, 23);
		messageCode.put(INAVLID_PARTNER_ID, 24);
		messageCode.put(INAVLID_PRODUCT_NAME, 25); 
		messageCode.put(INAVLID_PARTNER_NAME, 88);

		// LOCATION CONTANT
		messageCode.put(INAVLID_LOCATION_ID, 26);
		messageCode.put(BLANK_FIELD_LOCATION_ID, 26);
		messageCode.put(BLANK_FIELD_REGION_ID, 28);
		messageCode.put(BLANK_FIELD_COUNTRY_ID, 29);
		messageCode.put(BLANK_FIELD_METRO_ID, 30);
		messageCode.put(BLANK_FIELD_CAMPUS_ID, 31);
		
		messageCode.put(INAVLID_REGION_ID, 28);
		messageCode.put(INAVLID_COUNTRY_ID, 29);
		messageCode.put(INAVLID_CAMPUS_ID, 30);
		messageCode.put(INAVLID_METRO_ID, 31);

		// FAMILY CONSTANT
		messageCode.put(INAVLID_FAMILY_ID, 27);
		messageCode.put(INAVLID_FAMILY_NAME, 27);
		messageCode.put(BLANK_FAMILY_ID, 27);
		messageCode.put(BLANK_FAMILY_NAME, 27);
		
		// OWNERTYPE_ID CONSTANT
		messageCode.put(INAVLID_PRODUCT_OWNERTYPE_ID, 28);
	}

}
