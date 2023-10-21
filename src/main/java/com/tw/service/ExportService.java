package com.tw.service;

import jakarta.servlet.http.HttpServletResponse;

public interface ExportService {

	byte[] downloadPdfreceipt(Long id, HttpServletResponse response);


}
