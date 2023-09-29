package com.tw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tw.dto.RentDto;
import com.tw.service.RentService;
import com.tw.spec.RentSpecDto;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin
@RequestMapping("/rent")
public class RentController {

	@Autowired
	private RentService rentService;

	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody RentDto rent) {
		return rentService.saveRent(rent);
	}

	@PostMapping("/list")
	public ResponseEntity<?> findAllRent(@RequestBody RentSpecDto dto) {
		return rentService.findAllRent(dto);

	}

	@GetMapping("/findAll")
	public ResponseEntity<?> getRent() {
		return rentService.getRent();

	}

	@GetMapping("/rentById")
	public ResponseEntity<?> getRentById(@PathParam("id") Long id) {
		return rentService.getRentById(id);

	}

	@GetMapping("/deleteById")
	public ResponseEntity<?> deleteById(@PathParam("id") Long id) {
		return rentService.delete(id);

	}

	@GetMapping("/changeStatus")
	public ResponseEntity<?> changeStatus(@PathParam("id") Long id) {
		return rentService.changeStatus(id);

	}

	@GetMapping("/totalAmount")
	public ResponseEntity<?> totalAmount() {
		return rentService.totalAmount();
	}

	@GetMapping("/paidAmount")
	public ResponseEntity<?> paidAmount() {
		return rentService.paidAmount();
	}

	@GetMapping("/remainingAmount")
	public ResponseEntity<?> remainingAmount() {
		return rentService.remainingAmount();
	}

	@GetMapping("/shopOwnerById")
	public ResponseEntity<?> findByShopOwnerId(@PathParam("id") Long id) {
		return rentService.findByShopOwnerId(id);

	}

	@GetMapping("/sumOfRent")
	public ResponseEntity<?> findSum(@PathParam("id") Long id, @PathParam("year") String year) {
		return rentService.findSum(id, year);

	}

	@GetMapping("/year")
	public ResponseEntity<?> findByYear(@PathParam("year") String year) {
		return rentService.findByYear(year);
	}

	@GetMapping("/shopowneryear")
	public ResponseEntity<?> findByShopOwnerIdAndYear(@PathParam("id") Long id, @PathParam("year") String year) {
		return rentService.findByShopOwnerIdAndYear(id, year);
	}

}
