package com.shoppingcart.delivery.util;

public class ServiceConstant {

	public static final String SERVICE_URL_PREFIX = "/controller";
	
	public static final String REQ_MAP_URL_UserRegistrationService = SERVICE_URL_PREFIX +"/UserDeliveryRegistration";
	public static final String REQ_MAP_URL_UserDetailService = SERVICE_URL_PREFIX +"/userDetailsService";
	
	public static final String REQ_MAP_METHOD_URL_InsertBillAdd = "/insertbillingaddress";
	public static final String REQ_MAP_METHOD_URL_InsertShipAdd = "/insertshippingaddress";
	public static final String REQ_MAP_METHOD_URL_CustomerOrder = "/customerorder";
	
	public static final String REQ_MAP_METHOD_URL_getBillingAddressFromToken = "/getBillingAddressFromToken";
	public static final String REQ_MAP_METHOD_URL_getShippingAddressFromToken = "/getShippingAddressFromToken";
}
