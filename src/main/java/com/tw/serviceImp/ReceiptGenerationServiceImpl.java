package com.tw.serviceImp;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.tw.model.Rent;
import com.tw.model.RentSlave;
import com.tw.repository.RentRepository;
import com.tw.service.ReceiptService;

@Service
public class ReceiptGenerationServiceImpl implements ReceiptService {

	// ...

	@Autowired
	private RentRepository rentRepo;
	
	@Override
	public byte[] generatePdfReceipt(Long id) throws IOException, DocumentException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Document document = new Document();
		document.setMargins(20, 20, 20, 0);
		PdfWriter.getInstance(document, baos);
		document.open();

		Font header = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
		Font subheader = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
		Font footer = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
		header.setColor(10, 4, 2);

		Font tableheader = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
		Font tabletext = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
		Font small = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
		Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);// , GrayColor.GRAYWHITE

		document.newPage();
		PdfPTable HeaderTable1 = new PdfPTable(1);
		int[] headerwidth1 = { 95 };
		HeaderTable1.setWidths(headerwidth1);
		HeaderTable1.setWidthPercentage(95f);
		HeaderTable1.setHorizontalAlignment(Element.ALIGN_CENTER);

		BaseFont urduFont = BaseFont.createFont("/fonts/urdu_font.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font urduHeadingFont = new Font(urduFont, 12, Font.NORMAL);
		urduHeadingFont.setColor(10, 4, 2); // Set the color (RGB values)

		String urduDirectorBusiness = "مسلم انتظامیہ کمیٹی";
		String dictoraddress = "Jama Masjid, Momin Pura chowk,  ";
		String city = "Himayatnagar, Dist Nanded";
		String Zipcode = "431802.";

		Font regular = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
		Font bold = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD);

		Phrase p2 = new Phrase();
		p2.setFont(bold);
		p2.add(new Chunk(" \n" + urduDirectorBusiness,urduHeadingFont));
		p2.setFont(regular);
		p2.add(new Chunk(" \n" + dictoraddress));
		p2.add(new Chunk(" \n" + city + " " + Zipcode));
		p2.add(new Chunk(" \n\n"));

		PdfPCell rentcell2 = new PdfPCell(p2);
		rentcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		rentcell2.setBorder(Rectangle.BOTTOM);
		HeaderTable1.addCell(rentcell2);
		document.add(HeaderTable1);
		HeaderTable1.flushContent();

		// Table 1 : For hospital address details end
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm a");
		Date now = new Date(new java.util.Date().getTime());
		String strDate = sdf.format(now);
		String rtime = sdf2.format(now);

		// Table3 : For patient header info start
		PdfPTable HeaderTable3 = new PdfPTable(6);
		int[] headerwidth3 = { 15, 15, 15, 20, 15, 15 };
		HeaderTable3.setWidths(headerwidth3);
		HeaderTable3.setWidthPercentage(95f);
		HeaderTable3.getDefaultCell().setBorder(Rectangle.NO_BORDER);

		Rent r = rentRepo.getById(id);
		String recpNo = "";
		Date recpDate = null;
		String tenentName = "";
		String mobile = "";
		String address = "";
		if (r != null) {
			recpNo = r.getReceiptNo();
			recpDate = r.getReceiptDate();
			tenentName = r.getShopowner().getOwnerName();
			mobile = r.getShopowner().getMobileNo();
			address = r.getShopowner().getAddress();
		}

		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
		String receiptDate = null;
		try {
			receiptDate = format1.format(recpDate);

		} catch (java.lang.Exception e1) {
			e1.printStackTrace();
		}

		HeaderTable3.addCell(new Phrase("Receipt No", subheader));
		HeaderTable3.addCell(new Phrase(": " + recpNo, tabletext));

		HeaderTable3.addCell(new Phrase("Tenent Name", subheader));
		HeaderTable3.addCell(new Phrase(": " + tenentName, tabletext));

		HeaderTable3.addCell(new Phrase("Receipt Date", subheader));
		HeaderTable3.addCell(new Phrase(": " + receiptDate, tabletext));

		HeaderTable3.addCell(new Phrase("Mobile Number", subheader));
		HeaderTable3.addCell(new Phrase(": " + mobile, tabletext));

		HeaderTable3.addCell(new Phrase("Address", subheader));
		HeaderTable3.addCell(new Phrase(": " + address, tabletext));

		HeaderTable3.addCell(new Phrase("", subheader));
		HeaderTable3.addCell(new Phrase("", tabletext));

		HeaderTable3.setSpacingAfter(20);

		document.add(HeaderTable3);
		HeaderTable3.flushContent();

		PdfPTable HeaderTable5 = new PdfPTable(6);
		int[] headerwidth5 = { 2, 15, 15, 15, 15, 15 };
		HeaderTable5.setWidths(headerwidth5);
		HeaderTable5.setWidthPercentage(95f);
		HeaderTable5.getDefaultCell().setBorder(Rectangle.TOP);

		HeaderTable5.addCell(new Phrase("#", subheader));
		HeaderTable5.addCell(new Phrase("Shop name", subheader));

		HeaderTable5.addCell(new Phrase("RentType", subheader));
		HeaderTable5.addCell(new Phrase("Rent Amt", subheader));
		HeaderTable5.addCell(new Phrase("Paid Amt", subheader));

		HeaderTable5.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
		HeaderTable5.addCell(new Phrase("Remaining Amt", subheader));

		document.add(HeaderTable5);
		HeaderTable5.flushContent();
		Rectangle rect = new Rectangle(100, 100); // Width and height

		HeaderTable5.getDefaultCell().setBorder(rect.hashCode());

		for (int i = 0; i < r.getRentSlave().size(); i++) {
			RentSlave bs = r.getRentSlave().get(i);
			double rentAmount = bs.getRentAmount();
			String subName = bs.getShop().getShopName();
			String rentType = bs.getPaymentType();
			if (rentType.equals("R")) {
				rentType = "Rent";
			} else {
				rentType = "Deposite";
			}
			double paid = bs.getPaid();
			double remaining = bs.getRemaining();

			HeaderTable5.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

			PdfPCell cell01 = new PdfPCell(new Phrase("" + (i + 1), tabletext));
			cell01.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell01.setBorder(Rectangle.NO_BORDER);
			HeaderTable5.addCell(cell01);

			PdfPCell cell2 = new PdfPCell(new Phrase("" + subName, tabletext));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setBorder(Rectangle.NO_BORDER);
			HeaderTable5.addCell(cell2);

			PdfPCell cell22 = new PdfPCell(new Phrase("" + rentType, tabletext));
			cell22.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell22.setBorder(Rectangle.NO_BORDER);
			HeaderTable5.addCell(cell22);

			PdfPCell cell3 = new PdfPCell(new Phrase("" + rentAmount, tabletext));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setBorder(Rectangle.NO_BORDER);
			HeaderTable5.addCell(cell3);

			PdfPCell cell4 = new PdfPCell(new Phrase("" + paid, tabletext));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setBorder(Rectangle.NO_BORDER);
			HeaderTable5.addCell(cell4);

			PdfPCell cell5 = new PdfPCell(new Phrase("" + remaining, tabletext));
			cell5.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell5.setBorder(Rectangle.NO_BORDER);
			HeaderTable5.addCell(cell5);
		}

		double finalam = r.getTotalRentAmount();
		long finalams = (long) finalam;

		HeaderTable5.setSpacingAfter(20);

		document.add(HeaderTable5);
		HeaderTable5.flushContent();

		PdfPTable HeaderTable56 = new PdfPTable(3);
		int[] headerwidth56 = { 10, 50, 40 };
		HeaderTable56.setWidths(headerwidth56);
		HeaderTable56.setWidthPercentage(95f);
		HeaderTable56.getDefaultCell().setBorder(Rectangle.BOTTOM);
		HeaderTable56.getDefaultCell().setBorder(Rectangle.TOP);

		PdfPCell cell661 = new PdfPCell(new Phrase("", tabletext));
		cell661.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell661.setBorder(Rectangle.NO_BORDER);
		HeaderTable56.addCell(cell661);

		PdfPCell cell662 = new PdfPCell(new Phrase("Total Rent Amount   :", tabletext));
		cell662.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell662.setBorder(Rectangle.NO_BORDER);
		HeaderTable56.addCell(cell662);

		PdfPCell cell66 = new PdfPCell(new Phrase("" + r.getTotalRentAmount(), tabletext));
		cell66.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell66.setBorder(Rectangle.NO_BORDER);
		HeaderTable56.addCell(cell66);

		PdfPCell cell663 = new PdfPCell(new Phrase("", tabletext));
		cell663.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell663.setBorder(Rectangle.NO_BORDER);
		HeaderTable56.addCell(cell663);

		PdfPCell cell25 = new PdfPCell(new Phrase("Total Deposit Amount   :", tabletext));
		cell25.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell25.setBorder(Rectangle.NO_BORDER);
		HeaderTable56.addCell(cell25);

		PdfPCell cell26 = new PdfPCell(new Phrase("" + r.getTotalDepositAmount(), tabletext));
		cell26.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell26.setBorder(Rectangle.NO_BORDER);
		HeaderTable56.addCell(cell26);

		PdfPCell cell27 = new PdfPCell(new Phrase("", tabletext));
		cell27.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell27.setBorder(Rectangle.NO_BORDER);
		HeaderTable56.addCell(cell27);

		PdfPCell cell664 = new PdfPCell(new Phrase("Total Paid  :", tabletext));
		cell664.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell664.setBorder(Rectangle.NO_BORDER);
		HeaderTable56.addCell(cell664);

		PdfPCell cell55 = new PdfPCell(new Phrase("" + r.getTotalPaid(), tabletext));
		cell55.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell55.setBorder(Rectangle.NO_BORDER);
		HeaderTable56.addCell(cell55);

		PdfPCell cell665 = new PdfPCell(new Phrase("", tabletext));
		cell665.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell665.setBorder(Rectangle.NO_BORDER);
		HeaderTable56.addCell(cell665);

		PdfPCell cell666 = new PdfPCell(new Phrase("Total Balance  :", tabletext));
		cell666.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell666.setBorder(Rectangle.NO_BORDER);
		HeaderTable56.addCell(cell666);

		PdfPCell cell58 = new PdfPCell(new Phrase("" + r.getTotalRemaining(), tabletext));
		cell58.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell58.setBorder(Rectangle.NO_BORDER);
		HeaderTable56.addCell(cell58);

		document.add(HeaderTable56);
		HeaderTable56.flushContent();

		PdfPTable HeaderTable6 = new PdfPTable(2);
		int[] headerwidth6 = { 50, 50 };
		HeaderTable6.setWidths(headerwidth6);
		HeaderTable6.setWidthPercentage(95f);
		// HeaderTable6.getDefaultCell().setBorder(Rectangle.OUT_TOP);

		HeaderTable6.addCell(new Phrase("", subheader));
		HeaderTable6.addCell(new Phrase("", tabletext));

		HeaderTable6.addCell(new Phrase("Amount In Words :", subheader));

		// HeaderTable6.addCell(new Phrase("" +
		// (EnglishNumberToWords.convert(finalams)), tabletext));

		document.add(HeaderTable6);
		HeaderTable6.flushContent();

		document.add(HeaderTable1);
		HeaderTable1.flushContent();

		// Add the table to the document
		// document.add(table);

		document.close();
		return baos.toByteArray();
	}

}