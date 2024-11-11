package com.shoppingcart.delivery.dao;

import com.shoppingcart.delivery.vo.ShippingAddress;

public interface ShippingAddressDAO {

	Integer insertBillAdd(ShippingAddress shipAdd);

	ShippingAddress getShippingAddress(int shipAddressId);

}
