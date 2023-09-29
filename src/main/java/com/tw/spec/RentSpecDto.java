package com.tw.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentSpecDto {
	
	private Integer page;
	private Integer size;
	private String shopownerName;
	private String shopName;
	private String status;
	private String year;
}
