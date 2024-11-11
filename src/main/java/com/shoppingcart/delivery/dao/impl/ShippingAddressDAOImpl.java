package com.shoppingcart.delivery.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.shoppingcart.delivery.common.LoadJPAFQueries;
import com.shoppingcart.delivery.dao.SequencesDAO;
import com.shoppingcart.delivery.dao.ShippingAddressDAO;
import com.shoppingcart.delivery.vo.ShippingAddress;

import jakarta.annotation.PostConstruct;

@Repository
public class ShippingAddressDAOImpl extends JdbcDaoSupport implements ShippingAddressDAO{
	
	@Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }
    
    @Autowired
    SequencesDAO sequencesDAO;
    
    private static final String shippingAddSequence = "shippingaddress_seq";
    
    @Override
    public Integer insertBillAdd(ShippingAddress shipAdd)
    {
    	Integer shipAddId = sequencesDAO.getNextSequence(shippingAddSequence);
    	int count=0;
		count = getJdbcTemplate().update(LoadJPAFQueries.getQueryById("INSERT_SHIPPINGADDRESS"),
                new Object[] {
                		shipAddId, shipAdd.getAddress(), shipAdd.getCity(),
                		shipAdd.getCountry(), shipAdd.getState(), shipAdd.getZipcode()               		       
		 });
		if(count<=0)
		{
			return 0;
		}
		return shipAddId;
    }	
    
    @Override
    public ShippingAddress getShippingAddress(int shipAddressId)
    {
	 ShippingAddress shipAddress = getJdbcTemplate().queryForObject(LoadJPAFQueries.getQueryById("SELECT_ShippingAddress_BY_ID"), new Object[] { shipAddressId },
                BeanPropertyRowMapper.newInstance(ShippingAddress.class)); 
		return shipAddress;
    }
}
