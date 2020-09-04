package com.dxctraining.wishlistmgt.wishedItem.dto;

public class WishedItemDto {

	private String id;
	private String productId;
	private Integer customerId;
	private String customerName;
	private String productName;

	public WishedItemDto() {

	}

	public WishedItemDto(String id) {
		// this.customerId = customerId;
		// this.productId = productId;
		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
