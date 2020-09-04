package com.dxctraining.productmgt.service;

import java.util.List;

import com.dxctraining.productmgt.entities.Product;

public interface IProductService {
	 Product save(Product product);
	 void removeById(String id);
	List<Product> findByName(String name);
	Product findById(String id);

}
