package com.tw.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.model.Shop;
import com.tw.model.ShopOwner;
import com.tw.repository.OwnerRepository;
import com.tw.repository.ShopRepository;
import com.tw.service.OwnerServices;

@Service
public class OwnerServiceImpl implements OwnerServices {

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private ShopRepository shopRepo;
	
	@SuppressWarnings("deprecation")
	@Override
	public String saveUser(ShopOwner shopOwner) {
		String ret = "";
		ShopOwner shopowner = ownerRepository.findByShopId(shopOwner.getShop().getId());
		if (shopowner != null && shopowner.getShop().getId() > 0) {
			ret = "shop already assign to owner!";
		} else {
			Shop shop = shopRepo.getById(shopOwner.getShop().getId());
			shop.setRented(1);
			shopRepo.save(shop);
			ShopOwner save = ownerRepository.save(shopOwner);
			if (save != null)
				ret = "Save success";
		}
		return ret;
	}

	@Override
	public List<ShopOwner> getShopOwner() {
		return ownerRepository.findAll();
	}

	@Override
	public ShopOwner ownerById(Long id) {
		Optional<ShopOwner> findById = ownerRepository.findById(id);
		return findById.get();
	}

	@Override
	public String deleteOwner(Long id) {
		ownerRepository.deleteById(id);
		return "Deleted !";
	}

	@SuppressWarnings("deprecation")
	@Override
	public String changeStatus(Long id) {
		ShopOwner obj = ownerRepository.getById(id);
		obj.setStatus(0);
		ownerRepository.save(obj);
		return "Deleted !";
	}

}
