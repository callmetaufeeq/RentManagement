package com.tw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tw.model.Rent;
import com.tw.service.RentService;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin
@RequestMapping("/rent")
public class RentController {

	@Autowired
	private RentService rentService;

	@PostMapping("/save")
	public String saveUser(@RequestBody Rent rent) {
		String ret = rentService.saveRent(rent);
		return ret;
	}

	@GetMapping("/listrent")
	public List<Rent> getRent() {
		return rentService.getRent();

	}

	@GetMapping("/rentById")
	public Rent getRentById(@PathParam("id") Long id) {
		return rentService.getRentById(id);

	}

	@GetMapping("/deleteById")
	public Rent deleteById(@PathParam("id") Long id) {
		return rentService.delete(id);

	}

	@GetMapping("/changeStatus")
	public String changeStatus(@PathParam("id") Long id) {
		return rentService.changeStatus(id);

	}

	@GetMapping("/totalAmount")
	public Long totalAmount() {

		return rentService.totalAmount();

	}

	@GetMapping("/paidAmount")
	public Long paidAmount() {

		return rentService.paidAmount();

	}

	@GetMapping("/remainingAmount")
	public Long remainingAmount() {
		return rentService.remainingAmount();
	}
	
	@GetMapping("/shopOwnerById")
	public List<Rent> findByShopOwnerId(@PathParam("id") Long id){
		return rentService.findByShopOwnerId(id);
		
	}
}
