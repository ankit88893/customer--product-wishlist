package com.dxctraining.productmgt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.productmgt.dao.IProductDao;
import com.dxctraining.productmgt.entities.Product;
import com.dxctraining.productmgt.exception.ProductNotFoundException;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductDao productDao;

	@Override
	public Product save(Product product) {
		product = productDao.save(product);
		return product;
	}

	@Override
	public Product findById(String id) {
		Optional<Product> optional = productDao.findById(id);
		boolean exist = optional.isPresent();
		if (!exist) {
			throw new ProductNotFoundException("product not found for id= " + id);
		}
		Product product = optional.get();
		return product;
	}

	@Override
	public void removeById(String id) {
		productDao.deleteById(id);
	}

	@Override
	public List<Product> findByName(String name) {
		List<Product> list = productDao.findByName(name);
		return list;
	}
	
	

}
