package com.tw.controller;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.tw.service.ReceiptService;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

	@Autowired
	private ReceiptService receiptService;

	@GetMapping("/{id}/receipt")
	public ResponseEntity<byte[]> generatePdfReceipt(@PathVariable Long id) throws IOException, DocumentException {
		try {
			byte[] pdfBytes = receiptService.generatePdfReceipt(id);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("attachment", "receipt.pdf");

			return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return null;
		}
	}

}
