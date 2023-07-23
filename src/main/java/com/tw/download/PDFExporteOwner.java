package com.tw.download;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.tw.model.Shop;

import jakarta.servlet.http.HttpServletResponse;

public class PDFExporteOwner {

	private List<Shop> listShop;

	public void PDFExporterShop(List<Shop> listShop) {
		this.listShop = listShop;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Shop ID", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Shop Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Rent Type", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Status", font));
		table.addCell(cell);
	}

	private void writeTableData(PdfPTable table) {
		for (Shop s : listShop) {
			table.addCell(String.valueOf(s.getId()));
			table.addCell(s.getshopName());
			table.addCell(s.getRentType());
			if (s.getRented() == 1) {
				table.addCell("Rented");
			} else {
				table.addCell("Not Rented");
			}
			/*
			 * if (s.getRentType() == "Y") { table.addCell("Yearly"); } else {
			 * table.addCell("Monthly");
			 * 
			 * }
			 */
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(20);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("List of Shops", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f, 1.5f });
		table.setSpacingBefore(14);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}
}
