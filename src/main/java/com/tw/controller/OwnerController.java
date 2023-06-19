package com.tw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tw.model.ShopOwner;
import com.tw.repository.OwnerRepository;
import com.tw.service.OwnerServices;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/owners")
public class OwnerController {
	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private OwnerServices ownerServices;

	@PostMapping("/saveOwner")
	public String owners(@RequestBody ShopOwner shopOwner) {
		String saveUser = ownerServices.saveUser(shopOwner);
		return saveUser;
	}

	@GetMapping("/ownersList")
	public List<ShopOwner> getShopOwner() {
		return ownerServices.getShopOwner();
	}

	@GetMapping("/byId")
	public ShopOwner ownerById(@PathParam("id") Long id) {
		ShopOwner ownerById = ownerServices.ownerById(id);
		return ownerById;
	}

	@GetMapping("/delete")
	public ShopOwner deleteOwner(@PathParam("id") Long id) {
		ShopOwner deleteOwner = ownerServices.deleteOwner(id);
		return deleteOwner;
	}

}
