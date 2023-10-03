package com.tw;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.model.ShopOwnerSlave;

public interface ShopOwnerSlaveRepository extends JpaRepository<ShopOwnerSlave,Long>{

	
	ShopOwnerSlave findByShopId(Long shopID);

	Optional<ShopOwnerSlave> findOneByShopId(Long shopID);

}
