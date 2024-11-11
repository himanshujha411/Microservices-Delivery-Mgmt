package com.shoppingcart.delivery.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.delivery.bo.ShippingAddressBO;
import com.shoppingcart.delivery.dao.ShippingAddressDAO;
import com.shoppingcart.delivery.vo.ShippingAddress;

@Service
public class ShippingAddressBOImpl implements ShippingAddressBO{

	@Autowired
	ShippingAddressDAO shippingaddressDAO;
	
	@Override
	public int insertShipAdd(ShippingAddress shipAdd)
	{
		return shippingaddressDAO.insertBillAdd(shipAdd);
	}
	
	@Override
	public ShippingAddress getShippingAddress(int shipAddressId)
	{
		return shippingaddressDAO.getShippingAddress(shipAddressId);
	}
}
