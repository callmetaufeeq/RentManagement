package com.tw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.model.Shop;

public interface ShopRepository extends JpaRepository <Shop, Long> {
	

}
