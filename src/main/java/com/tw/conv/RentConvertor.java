package com.tw.conv;

import java.util.function.Function;

import com.tw.dto.RentListDto;
import com.tw.model.Rent;

public class RentConvertor implements Function<Rent,RentListDto> {

	@Override
	public RentListDto apply(Rent t) {
		RentListDto r =new RentListDto();
		r.setId(t.getId());
		r.setDepositAmount(t.getDepositAmount());
		r.setPaid(t.getPaid());
		r.setReceiptDate(t.getReceiptDate());
		r.setReceiptNo(t.getReceiptNo());
		r.setRemaining(t.getRemaining());
		r.setRentAmount(t.getRentAmount());
		r.setShopName(t.getShopowner().getShop().getShopName());
		r.setShopownerName(t.getShopowner().getOwnerName());
		r.setStatus(t.getStatus());
		return r;
	}
}
