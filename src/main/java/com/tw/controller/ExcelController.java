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

import com.tw.download.RentExcelExporter;
import com.tw.dto.RentListDto;
import com.tw.service.RentService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/excel")
public class ExcelController {
	
	@Autowired
	private RentService rentService;
	
	@GetMapping("/rent")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Rent" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List <RentListDto> listRent = (List<RentListDto>) rentService.getRent();
        RentExcelExporter generator = new RentExcelExporter(listRent);
        generator.generateExcelFile(response);
    }

}
