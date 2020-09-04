package com.dxctraining.productmgt.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dxctraining.productmgt.entities.Product;
import com.dxctraining.productmgt.service.IProductService;
import com.dxctraining.productmgt.service.ProductServiceImpl;

@ExtendWith(SpringExtension.class)
@DataMongoTest
@Import(ProductServiceImpl.class)
class ServiceTestImpl {

	@Autowired
	private IProductService service;

	@Test
	public void testAdd_2() {
		String name = "xperia";
		Product product = new Product(name);
		product = service.save(product);
		Product fetched = service.findById(product.getId());
		Assertions.assertEquals(product.getId(), fetched.getId());
		Assertions.assertEquals(name, fetched.getName());
	}

	@Test
	public void testFindById_2() {
		String name = "elitebook";
		Product product = new Product(name);
		product = service.save(product);
		String id = product.getId();
		Product fetched = service.findById(id);
		Assertions.assertEquals(fetched.getId(), id);
	}

}
