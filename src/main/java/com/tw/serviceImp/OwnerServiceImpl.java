package com.tw.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.model.ShopOwner;
import com.tw.repository.OwnerRepository;
import com.tw.service.OwnerServices;

@Service
public class OwnerServiceImpl implements OwnerServices {

	@Autowired
	private OwnerRepository ownerRepository;

	@Override
	public String saveUser(ShopOwner shopOwner) {
		String ret = "";
		ShopOwner save = ownerRepository.save(shopOwner);
		if (save != null)
			ret = "Save success";
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
	public ShopOwner deleteOwner(Long id) {
		ownerRepository.deleteById(id);
		return null;
	}

}
