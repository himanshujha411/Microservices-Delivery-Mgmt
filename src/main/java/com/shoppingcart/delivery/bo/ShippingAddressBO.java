package com.shoppingcart.delivery.bo;

import com.shoppingcart.delivery.vo.ShippingAddress;

public interface ShippingAddressBO {

	int insertShipAdd(ShippingAddress shipAdd);

	ShippingAddress getShippingAddress(int shipAddressId);

}
