package com.tw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tw.model.RentSlave;

public interface RentSlaveRepository extends JpaRepository<RentSlave, Long>, JpaSpecificationExecutor<RentSlave> {

	@Query("SELECT SUM(rs.paid) FROM RentSlave rs WHERE rs.shop.id = :shopId AND rs.year = :year AND rs.paymentType = :paymentType GROUP BY rs.shop.id")
	Double getSumPaid(@Param("shopId") Long shopId, @Param("year") String year,
			@Param("paymentType") String paymentType);

	@Query("SELECT DISTINCT rs.rentAmount FROM RentSlave rs WHERE rs.shop.id = :shopId AND rs.year = :year AND rs.paymentType = :paymentType")
	Double getRentAmount(@Param("shopId") Long shopId, @Param("year") String year,
			@Param("paymentType") String paymentType);

	@Query("SELECT DISTINCT rs.depositAmount FROM RentSlave rs WHERE rs.shop.id = :shopId AND rs.year = :year AND rs.paymentType = :paymentType")
	Double getDepositAmount(@Param("shopId") Long shopId, @Param("year") String year,
			@Param("paymentType") String paymentType);
}
