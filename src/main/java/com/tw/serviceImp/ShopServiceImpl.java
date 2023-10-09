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
public class ShopServiceImpl implements ShopService {

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
			msg = "Shop " + Messages.UPDATED_MSG;
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
	public ResponseEntity<?> getShop() {
		logger.info("Showing list of shops");
		List<Shop> shop=shopRepository.findAll();
		return Response.build(Code.OK,shop);
	}

	@Override
	public ResponseEntity<?> getShopById(Long id) {
		Optional<Shop> shop = shopRepository.findById(id);
		
		if (shop.isPresent()) {
			return Response.build(Code.OK, shop.get());
		} else {
			return Response.build(Code.OK, Messages.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<?> shopDelete(Long id) {
		boolean ispresent=false;
		if(id !=null) {
			Optional<Shop> sh=shopRepository.findById(id);
			if(sh.isPresent()) {
				ispresent=true;
				Shop shop=sh.get();
				shop.setDeleted(true);
				shopRepository.save(shop);
			}
		}
		if (ispresent) {
			return Response.build(Code.OK, Messages.DELETED);
		} else {
			return Response.build(Code.OK, Messages.NOT_FOUND);
		}
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