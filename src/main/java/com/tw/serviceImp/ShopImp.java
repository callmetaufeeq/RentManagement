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
		return shopRepository.findAll();
	}

	@Override
	public Shop getShopById(Long id) {
		Optional<Shop> shop=shopRepository.findById(id);
		return shop.get();
	}

	@Override
	public Shop shopDelete(Long id) {
		shopRepository.deleteById(id);
		return null;
	}
	/*
	 * @Override public Shop shopUpdate(Long id) { shopRepository. return null; }
	 */
	
   
   }
	 

	


