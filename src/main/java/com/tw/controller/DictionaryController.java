package com.tw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tw.service.DictionaryService;

@RestController
@RequestMapping("/number")
public class DictionaryController {

	@Autowired
	private DictionaryService dictionaryService;

	@GetMapping("/recieptNumber")
	public String recieptNo() {
		return dictionaryService.recieptNo();
	}

}
