package com.shoppingcart.delivery.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.delivery.bo.BillingAddressBO;
import com.shoppingcart.delivery.dao.BillingAddressDAO;
import com.shoppingcart.delivery.vo.BillingAddress;

@Service
public class BillingAddressBOImpl implements BillingAddressBO{
	
	@Autowired
	BillingAddressDAO billAddDAO;
	
	@Override
	public Integer insertBillAdd(BillingAddress billAdd)
	{
		return billAddDAO.insertBillAdd(billAdd);
	}
	
	@Override
	public BillingAddress getBillingAddress(int billAddressId)
	{
		return billAddDAO.getBillingAddress(billAddressId);
	}

}
