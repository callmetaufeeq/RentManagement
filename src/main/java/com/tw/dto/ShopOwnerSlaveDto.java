package com.tw.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopOwnerSlaveDto {
	private Long id;
	private String forWork;
	private int status=1;
	private Date date;
	private Date year;
	private Long shopID;
}
