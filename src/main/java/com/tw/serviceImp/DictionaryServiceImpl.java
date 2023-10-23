package com.tw.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.model.DictionaryCount;
import com.tw.repository.DictionaryRepository;
import com.tw.service.DictionaryService;

@Service
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryRepository dictionaryRepo;

	@Override
	public String recieptNo() {
		String type = "RCN";
		DictionaryCount obj = dictionaryRepo.getByType(type);
		int i = obj.getCount();
		String s = "RCN-" + i;
		return s;
	}
}
