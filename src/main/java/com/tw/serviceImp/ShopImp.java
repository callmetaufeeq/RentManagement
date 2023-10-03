package com.tw.serviceImp;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tw.dto.ShopDto;
import com.tw.generics.Code;
import com.tw.generics.Messages;
import com.tw.generics.Response;
import com.tw.model.Category;
import com.tw.model.Shop;
import com.tw.repository.CategoryRepository;
import com.tw.repository.ShopRepository;
import com.tw.service.ShopService;

@Service
public class ShopImp implements ShopService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ShopRepository shopRepository;

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public ResponseEntity<?> saveShop(ShopDto dto) {
		String msg = "";
		Shop obj = new Shop();
		if (dto.getId() != null && dto.getId() > 0) {
			obj = shopRepository.getById(dto.getId());
			obj.setModified(Calendar.getInstance());
			msg = "Shop" + Messages.UPDATED_MSG;
		} else {
			msg = "Shop " + Messages.CREATED_MSG;
			obj.setModified(Calendar.getInstance());
			obj.setCreated(Calendar.getInstance());
			obj.setId(dto.getId());
		}
		BeanUtils.copyProperties(dto, obj);
		if(dto.getCategoryId()!=null && dto.getCategoryId()>0) {
			Category c=categoryRepo.getById(dto.getCategoryId());
			obj.setCategory(c);
		}
		shopRepository.save(obj);
		return Response.build(Code.OK, msg);

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