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

import com.tw.dto.ShopDto;
import com.tw.model.Shop;
import com.tw.service.ShopService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/shop")
@CrossOrigin
public class ShopController {

	@Autowired
	private ShopService shopService;

	@PostMapping("/save")
	public ResponseEntity<?> saveShop(@RequestBody ShopDto shop) {
		return shopService.saveShop(shop);
	}

	@GetMapping("/listshop")
	public ResponseEntity<?> getShop() {
		return shopService.getShop();
	}

	@GetMapping("/shopById")
	public ResponseEntity<?> getShopById(@PathParam("id") Long id) {
		return shopService.getShopById(id);
	}

	@GetMapping("/deletebyid")
	public ResponseEntity<?> deleteByID(@PathParam("id") Long id) {
		return shopService.shopDelete(id);
	}

	@GetMapping("/changeStatus")
	public String changeStatus(@PathParam("id") Long id) {
		return shopService.changeStatus(id);
	}

	@GetMapping("/totalShops")
	public int totalShops() {
		return shopService.shop();
	}

	@GetMapping("/rentedShops")
	public int rentShop() {
		return shopService.rentShop();
	}

	@GetMapping("/leftShop")
	public int leftShop() {
		return shopService.leftShop();
	}
	
	@GetMapping("/categorybyid")
	public List<Shop> findBycategoryId (@PathParam("id")Long id) {
		return shopService.categoryId(id);
	}

	@GetMapping("/notRended")
	public List<Shop> getShopByRent(){
		return shopService.getShopByRent();
	}

}
