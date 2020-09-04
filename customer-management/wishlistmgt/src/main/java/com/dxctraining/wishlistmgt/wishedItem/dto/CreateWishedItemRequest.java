package com.dxctraining.wishlistmgt.wishedItem.dto;

public class CreateWishedItemRequest {

	private Integer customerId;
	private String productId;

	public CreateWishedItemRequest() {

	}

	public CreateWishedItemRequest(Integer customerId, String productId) {
		this.customerId = customerId;
		this.productId = productId;

	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}
