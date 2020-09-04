package com.dxctraining.wishlistmgt.wishedItem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dxctraining.wishlistmgt.wishedItem.entities.WishedItem;

public interface IWishlistDao extends JpaRepository<WishedItem,String> {
	
	@Query("from WishedItem where customerId=:customerId")
	List<WishedItem> findAllById(@Param("customerId")Integer customerId);


}
