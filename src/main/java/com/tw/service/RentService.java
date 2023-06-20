package com.tw.service;

import java.util.List;

import com.tw.model.Rent;

public interface RentService {
	String saveRent(Rent rent);

	List<Rent> getRent();

	Rent getRentById(Long id);

	Rent delete(Long id);
	
	String changeStatus(Long id);
	
	public Long totalAmount();
	
	public Long paidAmount();
	
	public Long remainingAmount();
}
