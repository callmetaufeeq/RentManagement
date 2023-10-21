package com.tw.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.tw.service.ExportService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("exportController")
public class ExportController {
	
	@Autowired
	private ExportService exportService;
	
	@GetMapping("icardfront/{id}")
	@ResponseBody
	public byte[] downloadPdfIdCardFront(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException, IOException {
		return exportService.downloadPdfreceipt(id, response);
	}

}
