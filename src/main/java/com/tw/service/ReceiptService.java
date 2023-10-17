package com.tw.service;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

public interface ReceiptService {
	byte[] generatePdfReceipt(Long id) throws IOException, DocumentException;

}
