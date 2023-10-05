package com.tw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tw.model.Rent;
import com.tw.model.ShopOwner;

public interface OwnerRepository extends JpaRepository<ShopOwner, Long> , JpaSpecificationExecutor<Rent> {


}
