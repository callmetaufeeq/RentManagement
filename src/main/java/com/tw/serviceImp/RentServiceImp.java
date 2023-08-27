package com.tw.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tw.customRepo.RentExternalRepo;
import com.tw.customRepo.RentExternalRepoYear;
import com.tw.dto.RentDto;
import com.tw.dto.RentSummaryDTO;
import com.tw.model.Rent;
import com.tw.repository.RentRepository;
import com.tw.service.RentService;
import com.tw.generics.Response;
import com.tw.generics.Code;
import com.tw.generics.Messages;

@Service
public class RentServiceImp implements RentService {

	@Autowired
	RentRepository rentRepository;

	@Autowired
	RentExternalRepo rentExternalRepo;

	@Autowired
	RentExternalRepoYear RentExternalRepoYear;

	@Override
	public ResponseEntity<?> saveRent(Rent rent) {
		rentRepository.save(rent);
		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}

	@Override
	public ResponseEntity<List<Rent>> getRent() {
		try {
			return new ResponseEntity<>(rentRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Rent> getRentById(Long id) {
		Optional<Rent> rent = rentRepository.findById(id);
		try {
			return new ResponseEntity<>(rent.get(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(rent.get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> delete(Long id) {
		rentRepository.deleteById(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

	@SuppressWarnings("deprecation")
	@Override
	public ResponseEntity<String> changeStatus(Long id) {
		Rent obj = rentRepository.getById(id);
		obj.setDeleted(true);
		rentRepository.save(obj);
		return new ResponseEntity<>("Status changed successfully ", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Long> totalAmount() {
		Long totalAmount = rentRepository.totalAmount();
		try {
			return new ResponseEntity<>(rentRepository.totalAmount(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(totalAmount, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Long> paidAmount() {
		Long paidAmount = rentRepository.paidAmount();
		try {
			return new ResponseEntity<>(rentRepository.paidAmount(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(paidAmount, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Long> remainingAmount() {
		Long remainingAmount = rentRepository.remainingAmount();
		try {
			return new ResponseEntity<>(rentRepository.remainingAmount(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(remainingAmount, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Rent>> findByShopOwnerId(Long id) {
		try {
			return new ResponseEntity<>(rentRepository.findByShopOwnerId(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<RentDto>> findSum(Long id, String year) {
		try {
			new ResponseEntity<>(rentExternalRepo.findSum(id, year), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<RentSummaryDTO>> findByYear(String year) {
//		return RentExternalRepoYear.findByYear(year);
		try {
			return new ResponseEntity<>(RentExternalRepoYear.findByYear(year), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

}
