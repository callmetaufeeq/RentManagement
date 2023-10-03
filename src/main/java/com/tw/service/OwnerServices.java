package com.tw.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tw.dto.ShopOwnerDto;
import com.tw.model.ShopOwner;

public interface OwnerServices {

	String saveUser(ShopOwnerDto shopOwner);

	List<ShopOwner> getShopOwner();

	ShopOwner ownerById(Long id);

	String deleteOwner(Long id);
	
	String changeStatus(Long id);
	
	ResponseEntity<?> shopsByOwnerId(Long id);

}
