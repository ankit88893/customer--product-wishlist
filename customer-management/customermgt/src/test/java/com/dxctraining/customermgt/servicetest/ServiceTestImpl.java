package com.dxctraining.customermgt.servicetest;

import static org.junit.jupiter.api.Assertions.*; 

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dxctraining.customermgt.customer.entities.Customer;
import com.dxctraining.customermgt.customer.exception.CustomerNotFoundException;
import com.dxctraining.customermgt.customer.service.CustomerServiceImpl;
import com.dxctraining.customermgt.customer.service.ICustomerService;



@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(CustomerServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerServiceImplTest {
	
	@Autowired
	private ICustomerService service;

	@Test
	public void testAdd_2() {
		String name = "arjun";
		Customer customer = new Customer(name);
		customer = service.save(customer);
		Customer fetched = service.findById(customer.getId());
		Assertions.assertEquals(customer.getId(),fetched.getId());
		Assertions.assertEquals(name,fetched.getName());
	}
	
	@Test
	public void testFindById_1() {
		Executable executable=()->service.findById(0);
		Assertions.assertThrows(CustomerNotFoundException.class, executable);
	}
	
	@Test
	public void testFindById_2() {
		String name = "vegita";
		Customer customer = new Customer(name);
		customer = service.save(customer);
		Customer fetched = service.findById(customer.getId());
		Assertions.assertEquals(customer.getId(), fetched.getId());
	}

}