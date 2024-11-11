package com.shoppingcart.delivery.dao;

import com.shoppingcart.delivery.vo.BillingAddress;

public interface BillingAddressDAO {

	Integer insertBillAdd(BillingAddress billAdd);

	BillingAddress getBillingAddress(int billAddressId);

}
