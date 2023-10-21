package com.tw.spec;

import java.sql.Date;

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
public class RentSpecDto {

	private Integer page;
	private Integer size;
	private String shopownerName;
	private String shopName;
	private String status;
	private String year;
	private String receiptNo;
	private Date receiptDate;
	private String mobileNo;
}
