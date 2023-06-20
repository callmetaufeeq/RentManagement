package com.tw.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.model.Rent;
import com.tw.repository.RentRepository;
import com.tw.service.RentService;

@Service
public class RentServiceImp implements RentService {

	@Autowired
	RentRepository rentRepository;

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
		Rent obj = new Rent();
		obj.setStatus(0);
		rentRepository.save(obj);
		return "Status changed successfully ";
	}

}
