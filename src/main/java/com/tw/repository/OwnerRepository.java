package com.tw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.model.ShopOwner;

public interface OwnerRepository extends JpaRepository<ShopOwner, Long> {

	ShopOwner findByShopId(Long id);

}
