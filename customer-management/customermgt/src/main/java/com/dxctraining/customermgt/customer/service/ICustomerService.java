package com.dxctraining.customermgt.customer.service;

import java.util.List;

import com.dxctraining.customermgt.customer.entities.Customer;

public interface ICustomerService  {
	
	void remove(Integer id);
	Customer findById(Integer id);
	List<Customer> findByName(String name);
	Customer save(Customer customer) ;
	

}
