package com.tw.service;

import java.util.List;

import com.tw.model.Shop;

public interface ShopService {
	String saveShop(Shop shop);

	List<Shop> getShop();

	Shop getShopById(Long id);

	String shopDelete(Long id);

	String changeStatus(Long id);
	
	//String counts (Long id);
}
