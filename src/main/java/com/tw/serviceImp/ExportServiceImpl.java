package com.tw.serviceImp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.tw.model.Rent;
import com.tw.repository.RentRepository;
import com.tw.service.ExportService;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ExportServiceImpl implements ExportService {

	@Autowired
	private Environment environment;

	@Autowired
	private RentRepository rentRepo;

	@Autowired
	private TemplateEngine templateEngine;

	@Override
	public byte[] downloadPdfreceipt(Long id, HttpServletResponse response) {
		Rent rent = rentRepo.getOne(id);
		String path = " ";
		String ownersName = "skk";
		String receiptNo = rent.getReceiptNo();
		Date receiptDate = rent.getReceiptDate();
		double remaining = rent.getTotalRemaining();

		String receipt = environment.getRequiredProperty("receipt.print");

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Context context = new Context();
		context.setVariable("ownerName", ownersName);
		context.setVariable("receiptNo", receiptNo);
		context.setVariable("receiptDate", receiptDate);
		context.setVariable("remaining", remaining);

		String html = templateEngine.process("receipt", context);
		ITextRenderer renderer = new ITextRenderer();

		renderer.setDocumentFromString(html);
		renderer.layout();

		try {
			renderer.createPDF(bos, false);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		renderer.finishPDF();
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + "receipt.pdf");
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();
	}

}