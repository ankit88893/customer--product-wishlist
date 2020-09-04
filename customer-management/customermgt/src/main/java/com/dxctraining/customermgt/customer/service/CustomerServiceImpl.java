package com.dxctraining.customermgt.customer.service;

import java.util.List; 
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.customermgt.customer.dao.ICustomerDao;
import com.dxctraining.customermgt.customer.entities.Customer;
import com.dxctraining.customermgt.customer.exception.CustomerNotFoundException;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerDao customerDao;
	
	
	@Override
	public Customer save(Customer customer) {
		customer= customerDao.save(customer);
			return customer;
	}
	
	@Override
	public List<Customer> findByName(String name) {
		List<Customer> list = customerDao.findByName(name);
		return list;
	}

	@Override
	public Customer findById(Integer id) {
		Optional<Customer> optional = customerDao.findById(id);
		if (!optional.isPresent()) {
			throw new CustomerNotFoundException("supplier not found for id=" + id);
		}
		Customer customer = optional.get();
		return customer;
	}

	@Override
	public void remove(Integer id) {
		customerDao.deleteById(id);
	}
	

}
