package com.shoppingcart.delivery.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.shoppingcart.delivery.common.LoadJPAFQueries;
import com.shoppingcart.delivery.dao.BillingAddressDAO;
import com.shoppingcart.delivery.dao.SequencesDAO;
import com.shoppingcart.delivery.vo.BillingAddress;

import jakarta.annotation.PostConstruct;

@Repository
public class BillingAddressDAOImpl extends JdbcDaoSupport implements BillingAddressDAO{

	@Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }
    
    @Autowired
    SequencesDAO sequencesDAO;
    
    private static final String billingAddSequence = "billingaddress_seq";
    
    @Override
    public Integer insertBillAdd(BillingAddress billAdd)
    {
    	Integer billAddId = sequencesDAO.getNextSequence(billingAddSequence);
    	int count=0;
		count =  getJdbcTemplate().update(LoadJPAFQueries.getQueryById("INSERT_BILLINGADDRESS"),
                new Object[] {
                		billAddId, billAdd.getAddress(), billAdd.getCity(),
                		billAdd.getCountry(), billAdd.getState(), billAdd.getZipcode()             		
		 });
		if(count<=0)
		{
			return 0;
		}
		return billAddId;
    }
    
    @Override
    public BillingAddress getBillingAddress(int billAddressId)
    {
    	BillingAddress billAddress = getJdbcTemplate().queryForObject(LoadJPAFQueries.getQueryById("SELECT_BillingAddress_BY_ID"), new Object[] { billAddressId },
                BeanPropertyRowMapper.newInstance(BillingAddress.class)); 
		return billAddress;
    }
}
