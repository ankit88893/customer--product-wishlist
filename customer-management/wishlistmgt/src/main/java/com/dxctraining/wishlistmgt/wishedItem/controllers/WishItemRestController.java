package com.dxctraining.wishlistmgt.wishedItem.controllers;

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
import org.springframework.web.client.RestTemplate;

import com.dxctraining.wishlistmgt.wishedItem.dto.CreateWishedItemRequest;
import com.dxctraining.wishlistmgt.wishedItem.dto.CustomerDto;
import com.dxctraining.wishlistmgt.wishedItem.dto.ProductDto;
import com.dxctraining.wishlistmgt.wishedItem.dto.WishedItemDto;
import com.dxctraining.wishlistmgt.wishedItem.entities.WishedItem;
import com.dxctraining.wishlistmgt.wishedItem.service.IWishlistService;
import com.dxctraining.wishlistmgt.wishedItem.util.WishedItemUtil;

@RestController
@RequestMapping("/wishlists")
public class WishItemRestController {
	

    @Autowired
    private IWishlistService service;

    @Autowired
    private WishedItemUtil wishedItemUtil;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public WishedItemDto addWishlist(@RequestBody CreateWishedItemRequest requestData) {
		WishedItem wishedItem = new WishedItem(requestData.getCustomerId(), requestData.getProductId());
		wishedItem = service.save(wishedItem);
		CustomerDto customerDto = findCustomerDetailsByCustId(requestData.getCustomerId());
		customerDto.setCustomerId(requestData.getCustomerId());
		ProductDto productDto = findProductDetailsByProductId(requestData.getProductId());
		WishedItemDto response = wishedItemUtil.wishedItemDto(wishedItem,customerDto.getCustomerId(),customerDto.getName(),productDto.getProductId(),productDto.getName());
		return response;
	}
    
    @GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<WishedItemDto> findAllWishedItemsById(@PathVariable("id")Integer customerId) {
		List<WishedItem>list = service.findAllById(customerId);
		List<WishedItemDto>response = new ArrayList<>();
		for(WishedItem wishedItem:list) {
			String productId = wishedItem.getProductId();
        	ProductDto productDto = findProductDetailsByProductId(productId);
        	Integer customerId1 = wishedItem.getCustomerId();
        	CustomerDto customerDto = findCustomerDetailsByCustId(customerId1);
			WishedItemDto dto = wishedItemUtil.wishedItemDto(wishedItem,customerId1,customerDto.getName(),productId, productDto.getName());
			response.add(dto);
		}
		return response;
	}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WishedItemDto> fetchAll() {
        List<WishedItem> list = service.allWishedItems();
        List<WishedItemDto>response=new ArrayList<>();
        for (WishedItem wishedItem:list){
        	String productId = wishedItem.getProductId();
        	ProductDto productDto = findProductDetailsByProductId(productId);
        	Integer custId = wishedItem.getCustomerId();
        	CustomerDto customerDto = findCustomerDetailsByCustId(custId);
            WishedItemDto dto=wishedItemUtil.wishedItemDto(wishedItem,custId,customerDto.getName(),productId, productDto.getName());
            response.add(dto);
        }
        return response;
    }
   
    public CustomerDto findCustomerDetailsByCustId(Integer customerId) {
    	String url = "http://localhost:8585/customers/get/"+customerId;
    	CustomerDto dto = restTemplate.getForObject(url, CustomerDto.class);
		return dto;
    }
    
    public ProductDto findProductDetailsByProductId(String productId) {
    	String url = "http://localhost:8586/products/get/"+productId;
    	ProductDto dto = restTemplate.getForObject(url, ProductDto.class);
		return dto;
    }

}




