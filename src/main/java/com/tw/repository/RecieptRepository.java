package com.tw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.model.RecieptNumber;

public interface RecieptRepository extends JpaRepository<RecieptNumber, Long>{
	
	
	RecieptNumber getByType(String type);

}
