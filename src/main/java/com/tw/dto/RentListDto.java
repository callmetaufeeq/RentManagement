package com.tw.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentListDto {

	private Long id;
	private double rentAmount;
	private double depositAmount;
	private double paid;
	private double remaining;
	private Date receiptDate;
	private String status;
	private String receiptNo;
	private String shopownerName;
	private String shopName;

}
