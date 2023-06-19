package com.productcatalogue.constant;

public interface UrlConstant {

	public interface Basic {
		String BASE_URL = "/api/v1";
	}

	public interface URL {

		// --------------------------- LOCATION ----------------------------------------
		String CREATE_LOCATION = "/location/create";
		String CREATE_PRODUCT_LOCATION_MAP = "/product/locationmap";
		String DEACTIVATE_LOCATION = "/location/deactivate/{locationId}";
		String UPDATE_LOCATION = "/location/update/{locationId}";
		String GET_LOCATION = "/location";
		String GET_PARTNER_PRODUCT_LOCATION = "/partner/locations/{locationId}";
		String GET_LOCATION_BY_SELCTED_PRODUCT_PARTNER = "/product/partner/{partnerId}/{locationId}";
		String GET_LOCATION_MAP = "/locationmapping";

		// --------------------------- PRODUCT FAMILY ----------------------------------
		String CREATE_PRODUCT_FAMILY = "/family/create";
		String GET_PRODUCT_FAMILY = "/family";
		String DEACTIVATE_PRODUCT_FAMILY = "/family/deactivate/{familyId}";
		String GET_PRODUCT_FAMILY_MAP = "/familymapping";

		// --------------------------- PRODUCT -----------------------------------------
		String CREATE_PRODUCT = "/product/create";
		String DEACTIVATE_PRODUCT = "/product/deactivate/{productId}";
		String GET_PRODUCT = "/product";
		String GET_PRODUCT_MAP = "/productmapping";
		String GET_PRODUCT_MAP_COUNT = "/productmapping/count";
		String GET_METRO = "/product/metro";
		String GET_CAMPUS = "/product/campus";
		String GET_COUNTRY = "/product/country";
		String GET_REGION = "/product/region";

		// --------------------------- PARTNER -----------------------------------------
		String CREATE_PARTNER = "/partner/create";
		String GET_PARTNER = "/partner";
		String GET_PARTNER_MAP = "/partnermapping";
		String GET_PARTNER_BY_LOCATION = "/partner/location/{locationId}";
		String GET_UNIQUE_PARTNER = "/partner/uniquepartner/{productId}";
		String UPDATE_PARTNER = "/partner/update";
		String GET_PARTNER_CATEGORY = "/partner/category";
		String GET_PARTNER_SUB_CATEGORY = "/partner/subcategory";
		String GET_PRODUCT_OWNER_TYPE = "/partner/ownertype";
		String GET_PARTNER_TYPE = "/partner/partnertype";
		String DEACTIVATE_PARTNER = "/partner/deactivate/{partnerId}";
		String GET_PRODUCT_LOCATION_MAP = "/partner/productlocationmap";
		String GET_PARTNER_BY_FAMILY_AND_LOCATION = "/partner/familylocation";
		String UPDATE_PARTNER_OLD = "/example/updatingxyz";

		
		

		interface Header {
			String AUTHORIZATION = "Auth";
		}
	}
}
