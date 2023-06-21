package com.tw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tw.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {

	@Query("SELECT COUNT(*) FROM Shop")
	public int totalShop();
	
	@Query("SELECT COUNT(*) FROM Shop WHERE rented = 1")
	public int rentedShop();
	
	@Query("SELECT COUNT(*) FROM Shop WHERE rented = 0")
	public int leftedShop();
	
	
}
