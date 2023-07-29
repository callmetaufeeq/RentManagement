package com.tw.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.customRepo.RentExternalRepo;
import com.tw.dto.RentDto;
import com.tw.model.Rent;
import com.tw.repository.RentRepository;
import com.tw.service.RentService;

@Service
public class RentServiceImp implements RentService {

	@Autowired
	RentRepository rentRepository;
	
	@Autowired 
	RentExternalRepo rentExternalRepo;

	@Override
	public String saveRent(Rent rent) {
		rentRepository.save(rent);
		return "Save Success!";
	}

	@Override
	public List<Rent> getRent() {
		return rentRepository.findAll();
	}

	@Override
	public Rent getRentById(Long id) {
		Optional<Rent> rent = rentRepository.findById(id);
		return rent.get();
	}

	@Override
	public Rent delete(Long id) {
		RentRepository rentRepository2 = rentRepository;
		rentRepository2.deleteById(id);
		System.out.println("Deleted Successfully");
		return (Rent) rentRepository2;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String changeStatus(Long id) {
		Rent obj = rentRepository.getById(id);
		obj.setStatus(0);
		rentRepository.save(obj);
		return "Status changed successfully ";
	}

	@Override
	public Long totalAmount() {

		return rentRepository.totalAmount();
	}

	@Override
	public Long paidAmount() {
		return rentRepository.paidAmount();
	}

	@Override
	public Long remainingAmount() {
		return rentRepository.remainingAmount();
	}

	@Override
	public List<Rent> findByShopOwnerId(Long id) {
		return rentRepository.findByShopOwnerId(id);
	}

	@Override
	public List<RentDto> findSum(Long id, String year) {
		List<RentDto> list= rentExternalRepo.findSum(id, year);
		
		return list;
	}

}
