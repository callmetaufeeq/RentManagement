package com.tw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tw.dto.ShopOwnerDto;
import com.tw.model.ShopOwner;
import com.tw.service.OwnerServices;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/owners")
@CrossOrigin
public class OwnerController {
	@Autowired
	private OwnerServices ownerServices;

	@PostMapping("/save")
	public ResponseEntity<?> owners(@RequestBody ShopOwnerDto shopOwner) {
		return ownerServices.saveUser(shopOwner);
	}

	@GetMapping("/list")
	public ResponseEntity<?> getShopOwner() {
		return ownerServices.getShopOwner();
	}

	@GetMapping("/byId")
	public ResponseEntity<?> ownerById(@PathParam("id") Long id) {
		return ownerServices.getShopOwner();
	}

	@GetMapping("/delete")
	public ResponseEntity<?> deleteOwner(@PathParam("id") Long id) {
		return ownerServices.deleteOwner(id);
	}

	@GetMapping("/status")
	public String checkStatus(@PathParam("id") Long id) {
		return ownerServices.changeStatus(id);
	}

	@GetMapping("/shopsByOwnerId")
	public ResponseEntity<?> shopByOwnerId(@PathParam("id") Long id) {
		return ownerServices.shopsByOwnerId(id);
	}
}
