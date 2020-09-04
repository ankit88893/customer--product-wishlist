package com.dxctraining.productmgt.util;

import org.springframework.stereotype.Component; 

import com.dxctraining.productmgt.dto.ProductDto;
import com.dxctraining.productmgt.entities.Product;

@Component
public class ProductUtil {

	public ProductDto productDto(Product product) {
		ProductDto dto = new ProductDto(product.getName(), product.getId());
		return dto;

	}

}
