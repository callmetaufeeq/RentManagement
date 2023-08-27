package com.tw.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tw.dto.RentDto;
import com.tw.dto.RentSummaryDTO;
import com.tw.model.Rent;

public interface RentService {
	ResponseEntity<?> saveRent(Rent rent);

    ResponseEntity<?> getRent();

	ResponseEntity<?> getRentById(Long id);

	ResponseEntity<?> delete(Long id);

	ResponseEntity<?> changeStatus(Long id);

	public ResponseEntity<?> totalAmount();

	public ResponseEntity<?> paidAmount();

	public ResponseEntity<?> remainingAmount();

	public ResponseEntity<List<Rent>> findByShopOwnerId(Long id);

	public ResponseEntity<List<RentDto>> findSum(Long id, String year);

	public ResponseEntity<List<RentSummaryDTO>> findByYear(String year);
}
