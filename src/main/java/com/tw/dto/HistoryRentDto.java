package com.tw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryRentDto {

	private double rentAmount ;
	private double depositAmount;
	private double paidAmount ;
	private double remainingAmount ;
}
