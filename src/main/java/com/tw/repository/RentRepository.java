package com.tw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tw.model.Rent;

public interface RentRepository extends JpaRepository<Rent, Long> {
	
	@Query(value = " SELECT sum(amount) FROM Rent")
	public Long totalAmount();
	
	@Query(value = " SELECT sum(paid) FROM Rent")
	public Long paidAmount();
	
	@Query(value = " SELECT sum(remaining) FROM Rent")
	public Long remainingAmount();
	
}
