package com.tw.dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentDto {

	private Long id;
	private double totalRentAmount;
	private double totalDepositAmount;
	private double totalPaid;
	private double totalRemaining;
	private Date receiptDate;
	private String status;
	private String receiptNo;
	private Long shopownerId;
	private Long userId;
	private String year;
	private List<RentSlaveDto> rentSlave;
}
