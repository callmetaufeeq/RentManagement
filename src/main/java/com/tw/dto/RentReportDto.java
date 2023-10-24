package com.tw.dto;

import java.util.Calendar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentReportDto {

	private String shopownerName;
	private String shopName;
	private String status;
	private String year;
	private String receiptNo;
	private Calendar receiptDate;
	private String mobileNo;
	private Calendar fromDate;
	private Calendar toDate;
}
