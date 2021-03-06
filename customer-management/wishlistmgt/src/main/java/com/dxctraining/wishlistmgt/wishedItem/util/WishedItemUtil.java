package com.dxctraining.wishlistmgt.wishedItem.util;

import org.springframework.stereotype.Component;

import com.dxctraining.wishlistmgt.wishedItem.dto.WishedItemDto;
import com.dxctraining.wishlistmgt.wishedItem.entities.WishedItem;

@Component
public class WishedItemUtil {

	public WishedItemDto wishedItemDto(WishedItem wishedItem, Integer customerId, String customerName, String productId,
			String productName) {
		WishedItemDto dto = new WishedItemDto(wishedItem.getId());
		dto.setCustomerId(customerId);
		dto.setCustomerName(customerName);
		dto.setProductId(productId);
		dto.setProductName(productName);
		return dto;
	}
}

/*
 * public WishedItemDto wishedItemDto(WishedItem wishedItem, Integer customerId,
 * String productId) { WishedItemDto dto = new
 * WishedItemDto(wishedItem.getId()); dto.setCustomerId(customerId); //
 * dto.setCustomerName(customerName); dto.setProductId(productId);
 * //dto.setProductName(productName); return dto; }
 */
