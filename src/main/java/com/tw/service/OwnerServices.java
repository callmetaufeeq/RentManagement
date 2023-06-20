package com.tw.service;

import java.util.List;

import com.tw.model.ShopOwner;

public interface OwnerServices {

	String saveUser(ShopOwner shopOwner);

	List<ShopOwner> getShopOwner();

	ShopOwner ownerById(Long id);

	String deleteOwner(Long id);
	
	String changeStatus(Long id);

}
