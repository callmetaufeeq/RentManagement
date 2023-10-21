package com.tw.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tw.dto.HistoryRentDto;
import com.tw.dto.RentDto;
import com.tw.dto.RentSummaryDTO;
import com.tw.model.Rent;
import com.tw.spec.RentSpecDto;

public interface RentService {
	ResponseEntity<?> saveRent(RentDto rent);

	ResponseEntity<?> getRentById(Long id);

	ResponseEntity<?> delete(Long id);

	ResponseEntity<?> changeStatus(Long id);

	public ResponseEntity<?> totalAmount();

	public ResponseEntity<?> paidAmount();

	public ResponseEntity<?> remainingAmount();

	public ResponseEntity<List<Rent>> findByShopOwnerId(Long id);

	public ResponseEntity<List<RentDto>> findSum(Long id, String year);

	public ResponseEntity<List<RentSummaryDTO>> findByYear(String year);

	public ResponseEntity<?> findByShopOwnerIdAndYear(Long id, String year);

	ResponseEntity<?> findAllRent(RentSpecDto dto);
	 
	ResponseEntity<?> findAllRentNew(RentSpecDto dto);

	ResponseEntity<?> getRent();
	
	ResponseEntity<HistoryRentDto> getAmt(Long shopId,String year,String paymentType);


}
