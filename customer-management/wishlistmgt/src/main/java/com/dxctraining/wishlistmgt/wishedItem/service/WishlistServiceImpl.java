package com.dxctraining.wishlistmgt.wishedItem.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.wishlistmgt.wishedItem.dao.IWishlistDao;
import com.dxctraining.wishlistmgt.wishedItem.entities.WishedItem;
import com.dxctraining.wishlistmgt.wishedItem.exception.InvalidArgumentException;

@Transactional
@Service
public class WishlistServiceImpl implements IWishlistService {
	@Autowired
	private IWishlistDao dao;

	
	int generated;
	
	public String generateId(){
		String id = "wishlist"+generated++;
		return id;
		}
	
	
	@Override
	public WishedItem save(WishedItem wishedItem) {
		String id = generateId();
		wishedItem.setId(id);
		validate(wishedItem);
		wishedItem = dao.save(wishedItem);
		return wishedItem;
	}
/*
	private String generateId() {

		Random ranNum = new Random();
		int generate = ranNum.nextInt(99999);
		return "Wishlist" + generate + "";
	}
*/
	private void validate(WishedItem wishedItem) {
		if (wishedItem == null) {
			throw new InvalidArgumentException("WISHEDITEM SHOULD NOT BE NULL");
		}

	}

	@Override
	public List<WishedItem> allWishedItems() {
		List<WishedItem> list = dao.findAll();
		return list;
	}

	@Override
	public List<WishedItem> findAllById(Integer customerId) {
		validateId(customerId);
		List<WishedItem> list = dao.findAllById(customerId);
		return list;
	}

	private void validateId(Integer customerId) {
		if (customerId == 0) {
			throw new InvalidArgumentException("id should not be null");
		}

	}

}