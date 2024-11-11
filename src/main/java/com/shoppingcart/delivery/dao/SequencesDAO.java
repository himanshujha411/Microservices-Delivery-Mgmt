package com.shoppingcart.delivery.dao;

import com.shoppingcart.delivery.vo.ShippingAddress;

public interface SequencesDAO {
	int getNextSequence(String sequenceName);

}
