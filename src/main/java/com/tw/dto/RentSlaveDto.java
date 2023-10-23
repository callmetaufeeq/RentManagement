package com.tw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentSlaveDto {

	private Long id;
	private double rentAmount;
	private double depositAmount;
	private double paid;
	private double remaining;
	private String rentType;
	private String year;
	private Long shopId;
	private String shopName;
}
