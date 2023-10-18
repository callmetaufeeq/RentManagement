package com.tw.conv;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.tw.dto.RentListDto;
import com.tw.dto.RentSlaveDto;
import com.tw.model.Rent;
import com.tw.model.RentSlave;

public class RentConvertor implements Function<Rent,RentListDto> {

	@Override
	public RentListDto apply(Rent t) {
		RentListDto r =new RentListDto();
		r.setId(t.getId());
		r.setDepositAmount(t.getTotalDepositAmount());
		r.setPaid(t.getTotalPaid());
		r.setReceiptDate(t.getReceiptDate());
		r.setReceiptNo(t.getReceiptNo());
		r.setRemaining(t.getTotalRemaining());
		r.setRentAmount(t.getTotalRentAmount());
		r.setShopownerName(t.getShopowner().getOwnerName());
		r.setStatus(t.getStatus());

        List<RentSlaveDto> rentSlaveDtos = new ArrayList<>();
	 
		for (RentSlave rentS : t.getRentSlave()){
			RentSlaveDto dto=new RentSlaveDto();
			dto.setId(rentS.getId());
			dto.setDepositAmount(rentS.getDepositAmount());
			dto.setPaid(rentS.getPaid());
			dto.setPaymentType(rentS.getPaymentType());
			dto.setRemaining(rentS.getRemaining());
			dto.setRentAmount(rentS.getRentAmount());
			dto.setYear(rentS.getYear());
			dto.setShopId(rentS.getShop().getId());
			dto.setShopName(rentS.getShop().getShopName());
			rentSlaveDtos.add(dto);
		}
		r.setRentSlave(rentSlaveDtos);
		return r;
	}
}
