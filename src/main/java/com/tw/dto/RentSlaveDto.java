package com.tw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentSlaveDto {

	private Long id;
	private double paid;
	private double remaining;
	private String paymentType;
	private String year;
}
