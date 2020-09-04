package com.dxctraining.productmgt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.productmgt.dto.CreateProductRequest;
import com.dxctraining.productmgt.dto.ProductDto;
import com.dxctraining.productmgt.entities.Product;
import com.dxctraining.productmgt.service.IProductService;
import com.dxctraining.productmgt.util.ProductUtil;

@RestController
@RequestMapping("/products")
public class ProductRestController {

	@Autowired
	private IProductService productService;

	@Autowired
	private ProductUtil util;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDto create(@RequestBody CreateProductRequest requestData) {
		Product product = new Product();
		product.setName(requestData.getName());
		product = productService.save(product);
		ProductDto response = util.productDto(product);
		return response;
	}

	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductDto findProductBy(@PathVariable("id") String id) {
		Product product = productService.findById(id);
		ProductDto response = util.productDto(product);
		return response;
	}

	@GetMapping("/get/product/{name}")	
	@ResponseStatus(HttpStatus.OK)
	public List<ProductDto> findProductByName(@PathVariable("name") String name){
		List<Product> list = productService.findByName(name);
		List<ProductDto> response = new ArrayList<>();
		for(Product product:list) {
		ProductDto dto	=util.productDto(product);
		response.add(dto);
		}
		return response;
		
	}

}
