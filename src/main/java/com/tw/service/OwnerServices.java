package com.tw.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tw.dto.ShopOwnerDto;
import com.tw.model.ShopOwner;

public interface OwnerServices {

	ResponseEntity<?> saveUser(ShopOwnerDto shopOwner);

	ResponseEntity<?> getShopOwner();

	ResponseEntity<?> ownerById(Long id);

	ResponseEntity<?>  deleteOwner(Long id);
	
	String changeStatus(Long id);
	
	ResponseEntity<?> shopsByOwnerId(Long id);

}
