package com.tw.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.model.RecieptNumber;
import com.tw.repository.RecieptRepository;
import com.tw.service.RecieptService;

@Service
public class ReceiptServiceImpl implements RecieptService{
	
	@Autowired
	private RecieptRepository recieptRepo;

	@Override
	public String recieptNo() {
		String type="RcNo";
		RecieptNumber obj=recieptRepo.getByType(type);
		int i=obj.getCount();
		String s="RcNo-"+i;
		return s;
	}
}
