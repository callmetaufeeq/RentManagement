package com.tw.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.model.Shop;
import com.tw.repository.ShopRepository;
import com.tw.service.ShopService;

@Service
public class ShopImp implements ShopService {

	@Autowired
	private ShopRepository shopRepository;

	@Override
	public String saveShop(Shop shop) {
		shopRepository.save(shop);
		return "saved successfully!";
	}

	@Override
	public List<Shop> getShop() {
		return shopRepository.findAllByOrderByIdDesc();
	}

	@Override
	public Shop getShopById(Long id) {
		Optional<Shop> shop = shopRepository.findById(id);
		return shop.get();
	}

	@Override
	public String shopDelete(Long id) {
		shopRepository.deleteById(id);
		return "deleted";
	}

	@SuppressWarnings("deprecation")
	@Override
	public String changeStatus(Long id) {
		Shop obj = shopRepository.getById(id);
		obj.setStatus(0);
		shopRepository.save(obj);
		return "Changed successfully!";
	}

	@Override
	public int shop() {
		int totalShop = shopRepository.totalShop();
		return totalShop;
	}


	@Override
	public int rentShop() {
		int rentShop = shopRepository.rentedShop();
		return rentShop;
	}

	@Override
	public int leftShop() {
		int leftShop = shopRepository.leftedShop();
		return leftShop; 
	}

	@Override
	public List<Shop> categoryId(Long id) {
			return shopRepository.findByCategoryId(id);

	}

	@Override
	public List<Shop> getShopByRent() {
		return shopRepository.getShopByRented();
	}

	
}