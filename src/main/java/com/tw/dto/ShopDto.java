package com.tw.dto;

import java.util.Date;
import java.util.List;

import com.tw.model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDto {
	
	private Long id;
	private String shopName;
	private double rent;
	private String address;
	private Date joinDate;
	private String rentType;
	private int status = 1;
	private int rented = 0;
	private String shopCode;
	private Long categoryId;
	
	
	
	
	
	
}
