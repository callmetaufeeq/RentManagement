package com.tw.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopOwnerDto {

	private Long id;

	private String ownerName;

	private String mobileNo;

	private String address;

	private List<ShopOwnerSlaveDto> shopownerSlave;
}
