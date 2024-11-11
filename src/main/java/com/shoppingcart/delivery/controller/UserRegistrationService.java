package com.shoppingcart.delivery.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.delivery.bo.BillingAddressBO;
import com.shoppingcart.delivery.bo.ShippingAddressBO;
import com.shoppingcart.delivery.util.ServiceConstant;
import com.shoppingcart.delivery.vo.BillingAddress;
import com.shoppingcart.delivery.vo.ShippingAddress;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = ServiceConstant.REQ_MAP_URL_UserRegistrationService)
public class UserRegistrationService {

	final static Logger LOG = LoggerFactory.getLogger(UserRegistrationService.class);
	
	@Autowired
	BillingAddressBO billAddBO;
	
	@Autowired
	ShippingAddressBO shipAddBO;
	
	@RequestMapping(value = ServiceConstant.REQ_MAP_METHOD_URL_InsertBillAdd, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> insertbillingaddress(@RequestBody BillingAddress billAdd,
														HttpServletRequest request) throws AuthenticationException
	{
		// BillingAddress Validation
		if(billAdd==null)
		{
			LOG.info("BillingAddress is NULL");
			return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
		}
		
		// Insert BillingAddress
		int insertBillAddCount = billAddBO.insertBillAdd(billAdd);
		if(insertBillAddCount<=0)
		{
			LOG.info("insert BillingAddress failed");
			return new ResponseEntity<>(0,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(insertBillAddCount, HttpStatus.OK);
	}
	
	@RequestMapping(value = ServiceConstant.REQ_MAP_METHOD_URL_InsertShipAdd, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> insertshippingaddress(@RequestBody ShippingAddress shipAdd,
														HttpServletRequest request) throws AuthenticationException
	{
		// BillingAddress Validation
		if(shipAdd==null)
		{
			LOG.info("BillingAddress is NULL");
			return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
		}
		
		// Insert BillingAddress
		int insershipAddCount = shipAddBO.insertShipAdd(shipAdd);	
		if(insershipAddCount<=0)
		{		
			LOG.info("insert ShippingAddress failed");
			return new ResponseEntity<>(0,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(insershipAddCount, HttpStatus.OK);
	}
}
