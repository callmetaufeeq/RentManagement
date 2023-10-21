package com.tw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.tw.model.Rent;

public interface RentRepository extends JpaRepository<Rent, Long>, JpaSpecificationExecutor<Rent> {

	@Query(value = " SELECT sum(totalRentAmount) FROM Rent")
	public Long totalAmount();

	@Query(value = " SELECT sum(totalPaid) FROM Rent")
	public Long paidAmount();

	@Query(value = " SELECT sum(totalRemaining) FROM Rent")
	public Long remainingAmount();

	public List<Rent> findByShopownerId(Long id);

}
