package com.tw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.tw.model.Rent;

public interface RentRepository extends JpaRepository<Rent, Long>, JpaSpecificationExecutor<Rent> {

	@Query(value = " SELECT sum(rentAmount) FROM Rent")
	public Long totalAmount();

	@Query(value = " SELECT sum(paid) FROM Rent")
	public Long paidAmount();

	@Query(value = " SELECT sum(remaining) FROM Rent")
	public Long remainingAmount();

	public List<Rent> findByShopownerId(Long id);

//	@Query("SELECT r FROM Rent r JOIN r.shopOwner s WHERE s.id = :shopOwnerId AND r.year = :year")
//	List<Rent> findByShopOwnerIdAndYear(Long shopOwnerId, String year);

}
