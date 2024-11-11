package com.shoppingcart.delivery.bo;

import com.shoppingcart.delivery.vo.BillingAddress;

public interface BillingAddressBO {

	Integer insertBillAdd(BillingAddress billAdd);

	BillingAddress getBillingAddress(int billAddressId);

}
