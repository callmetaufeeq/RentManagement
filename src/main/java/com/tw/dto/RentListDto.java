package com.tw.dto;


import java.util.Calendar;
import java.util.List;

import com.tw.model.RentSlave;

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
	private Calendar receiptDate;
	private String status;
	private String receiptNo;
	private String shopownerName;
	private List<RentSlaveDto> rentSlave;

}
