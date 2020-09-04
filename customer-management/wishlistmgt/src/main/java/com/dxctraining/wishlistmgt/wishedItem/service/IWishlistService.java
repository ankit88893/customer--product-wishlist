package com.dxctraining.wishlistmgt.wishedItem.service;

import java.util.List;

import com.dxctraining.wishlistmgt.wishedItem.entities.WishedItem;

public interface IWishlistService {

	WishedItem save(WishedItem wishedItem);

	List<WishedItem> findAllById(Integer custId);

	List<WishedItem> allWishedItems();

}