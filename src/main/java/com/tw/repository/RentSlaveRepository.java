package com.tw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.tw.model.RentSlave;

public interface RentSlaveRepository extends JpaRepository<RentSlave, Long>, JpaSpecificationExecutor<RentSlave> {
//
//	@Query(value = "select RentSlave(SUM(d.depositAmount) as depositAmount, SUM(d.paid) as paid) "
//			+"from RentSlave d where d.shop.id = ?1 AND d.year =?2 AND d.paymentType =?3 group by  d.shop.id")
//	RentSlave getTotalAmount(Long shopid, String year, String type);

}
