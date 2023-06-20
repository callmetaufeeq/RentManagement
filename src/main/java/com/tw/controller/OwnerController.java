package com.tw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tw.model.ShopOwner;
import com.tw.service.OwnerServices;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/owners")
public class OwnerController {
	@Autowired
	private OwnerServices ownerServices;

	@PostMapping("/save")
	public String owners(@RequestBody ShopOwner shopOwner) {
		String saveUser = ownerServices.saveUser(shopOwner);
		return saveUser;
	}

	@GetMapping("/owners")
	public List<ShopOwner> getShopOwner() {
		return ownerServices.getShopOwner();
	}

	@GetMapping("/byId")
	public ShopOwner ownerById(@PathParam("id") Long id) {
		ShopOwner ownerById = ownerServices.ownerById(id);
		return ownerById;
	}

	@GetMapping("/delete")
	public String deleteOwner(@PathParam("id") Long id) {
		String deleteOwner = ownerServices.deleteOwner(id);
		return deleteOwner;
	}

	@GetMapping("/status")
	public String checkStatus(@PathParam("id") Long id) {
		return ownerServices.changeStatus(id);
	}

}
