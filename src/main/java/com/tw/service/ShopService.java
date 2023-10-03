package com.tw.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tw.dto.ShopDto;
import com.tw.model.Shop;

public interface ShopService {
	ResponseEntity<?> saveShop(ShopDto dto);

	List<Shop> getShop();

	Shop getShopById(Long id);

	String shopDelete(Long id);

	String changeStatus(Long id);

	public int shop();

	public int rentShop();
	 
	public int leftShop();
	
	public List<Shop> categoryId(Long id);
	
	public List<Shop> getShopByRent();


}
