package com.tw.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.tw.download.PDFExporterOwner;
import com.tw.download.PDFExporterShop;
import com.tw.model.Shop;
import com.tw.model.ShopOwner;
import com.tw.repository.OwnerRepository;
import com.tw.repository.ShopRepository;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/pdf")
public class PDFController {

	@Autowired
	private ShopRepository shopRepo;

	@Autowired
	private OwnerRepository ownerRepo;

	@GetMapping("/shoplist")
	public void exportToPDFShop(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=shops_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<Shop> listShops = shopRepo.findAll();

		PDFExporterShop exporter = new PDFExporterShop(listShops);
		exporter.export(response);
	}

	@GetMapping("/ownerlist")
	public void exportToPDFOwner(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=owner_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<ShopOwner> owner = ownerRepo.findAll();

		PDFExporterOwner exporter = new PDFExporterOwner(owner);
		exporter.export(response);
	}
}
