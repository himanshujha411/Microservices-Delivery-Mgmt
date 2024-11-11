package com.shoppingcart.delivery.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.delivery.bo.BillingAddressBO;
import com.shoppingcart.delivery.bo.ShippingAddressBO;
import com.shoppingcart.delivery.services.AuthService;
import com.shoppingcart.delivery.util.ServiceConstant;
import com.shoppingcart.delivery.vo.BillingAddress;
import com.shoppingcart.delivery.vo.Customer;
import com.shoppingcart.delivery.vo.ShippingAddress;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = ServiceConstant.REQ_MAP_URL_UserDetailService)
public class UserDetailServices {
	
	@Autowired
	BillingAddressBO billAddressBO;
	
	@Autowired
	ShippingAddressBO shipAddressBO;
	
	@Autowired
	AuthService authService;
	
	private static final String TOKEN_HEADER = "Authorization";

	@RequestMapping(value = ServiceConstant.REQ_MAP_METHOD_URL_getBillingAddressFromToken, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getBillingAddress(HttpServletRequest request)
	{
		BillingAddress billAdd = null;
		
		Map<String,Object> statusMap = new HashMap<>();
		
		try {
			if(request.getHeader(TOKEN_HEADER)!=null) {
				Customer customer = authService.findCustomerFromToken(request);
				int billAddressId = customer.getBillingAddressId();
				billAdd = billAddressBO.getBillingAddress(billAddressId);
			}
			else {
				statusMap.put("error", "No user session found, please login again");
				return new ResponseEntity<>(statusMap, HttpStatus.FORBIDDEN);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(billAdd != null) {
			return new ResponseEntity<>(billAdd,HttpStatus.OK);
		}
		else {
			statusMap.put("error", "Billing Address Not Found!");
			return new ResponseEntity<>(statusMap,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = ServiceConstant.REQ_MAP_METHOD_URL_getShippingAddressFromToken, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getShippingAddress(HttpServletRequest request)
	{
		ShippingAddress shipAdd = null;
		
		Map<String,Object> statusMap = new HashMap<>();
		
		try {
			Customer customer = authService.findCustomerFromToken(request);
			int shipAddressId = customer.getShippingAddressId();
			shipAdd = shipAddressBO.getShippingAddress(shipAddressId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(shipAdd != null) {
			return new ResponseEntity<>(shipAdd,HttpStatus.OK);
		}
		else {
			statusMap.put("error", "Shipping Address Not Found!");
			return new ResponseEntity<>(statusMap,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
