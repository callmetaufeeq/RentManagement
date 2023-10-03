package com.tw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tw.service.RecieptService;

@RestController
@RequestMapping("/number")
public class RecieptController {

	@Autowired
	private RecieptService recieptService;

	@GetMapping("/recieptNumber")
	public String recieptNo() {
		return recieptService.recieptNo();
	}

}
