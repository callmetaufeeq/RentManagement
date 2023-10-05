package com.tw.serviceImp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tw.ShopOwnerSlaveRepository;
import com.tw.dto.ShopOwnerDto;
import com.tw.dto.ShopOwnerSlaveDto;
import com.tw.generics.Code;
import com.tw.generics.Messages;
import com.tw.generics.Response;
import com.tw.model.Shop;
import com.tw.model.ShopOwner;
import com.tw.model.ShopOwnerSlave;
import com.tw.repository.OwnerRepository;
import com.tw.repository.ShopRepository;
import com.tw.service.OwnerServices;

@Service
public class OwnerServiceImpl implements OwnerServices {

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private ShopRepository shopRepo;
	
	@Autowired
	private ShopOwnerSlaveRepository shopOwnerSlaveRepo;
	
	@SuppressWarnings("deprecation")
	@Override
	public String saveUser(ShopOwnerDto shopdto) {
		String msg = "";
		ShopOwner obj=new ShopOwner();
		if(shopdto.getId()!=null && shopdto.getId()>0) {
			obj =ownerRepository.getById(shopdto.getId());
			obj.setModified(Calendar.getInstance());
			msg = "Tenant " +Messages.UPDATED_MSG;
		}else {
			obj.setCreated(Calendar.getInstance());
			obj.setModified(Calendar.getInstance());
			msg = "Tenant " +Messages.CREATED_MSG;
		}
		obj.setAddress(shopdto.getAddress());
		obj.setMobileNo(shopdto.getMobileNo());
		obj.setOwnerName(shopdto.getOwnerName());

		if (shopdto.getShopownerSlave() != null) {
			List<ShopOwnerSlave> shopslave = new ArrayList<ShopOwnerSlave>();
			for (ShopOwnerSlaveDto s : shopdto.getShopownerSlave()) {
				ShopOwnerSlave t = new ShopOwnerSlave();
				if (s.getShopID() != null && s.getShopID() > 0) {
					Optional<ShopOwnerSlave> opt = shopOwnerSlaveRepo.findOneByShopId(s.getShopID());
					if (opt.isPresent()) {
						t = shopOwnerSlaveRepo.findByShopId(s.getShopID());
					}
					Shop shop = shopRepo.getById(s.getShopID());
					//shop.setRented(1);
					t.setShop(shop);
				}
				t.setForWork(s.getForWork());
				t.setYear(s.getYear());
				t.setDate(s.getDate());
				t.setCreated(Calendar.getInstance());
				t.setModified(Calendar.getInstance());
				t.setShopOwner(obj);
				shopslave.add(t);
			}
			obj.setShopownerSlave(shopslave);
		}
		ownerRepository.save(obj);
		return msg;
	}

	@Override
	public List<ShopOwner> getShopOwner() {
		return ownerRepository.findAll();
	}

	@Override
	public ShopOwner ownerById(Long id) {
		ShopOwner obj =ownerRepository.getById(id);
		 return obj;
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
		//obj.setStatus(0);
		ownerRepository.save(obj);
		return "Deleted !";
	}

	@Override
	public ResponseEntity<?> shopsByOwnerId(Long id) {
		Optional<ShopOwner> rent = ownerRepository.findById(id);
		return Response.build(Code.OK, rent.get());
	}

}
