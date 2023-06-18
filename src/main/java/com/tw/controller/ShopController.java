package com.tw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tw.model.Shop;
import com.tw.service.ShopService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private ShopService shopService;
	
	@PostMapping("/save")
	public String saveUser(@RequestBody Shop shop) {
		String ret = shopService.saveShop(shop);
		return ret;
	}
	
	@GetMapping("/listshop")
	public List<Shop> getShop() {
		return shopService.getShop();
	}
	
	
	@GetMapping("/shopById")
	public Shop getShopById(@PathParam("id") Long id) {
		
		return shopService.getShopById(id);
	}
	
	@GetMapping("/deleteById")
	public Shop deleteByID(@PathParam("id") Long id) {
		return shopService.delete(id);
	}
}
