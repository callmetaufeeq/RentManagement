package com.tw.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.tw.dto.RentReportDto;

import jakarta.persistence.criteria.Predicate;

public class ReportSpecification {

	public static Specification<Rent> buildSpecification(RentReportDto dto) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.isNotEmpty(dto.getShopownerName())) {
				predicates.add(criteriaBuilder.like(root.get("shopowner").get("ownerName"),
						"%" + dto.getShopownerName() + "%"));
			}

			if (StringUtils.isNotEmpty(dto.getShopName())) {
				predicates.add(criteriaBuilder.like(root.get("rentSlave").get("shop").get("shopName"),
						"%" + dto.getShopName() + "%"));
			}

			if (StringUtils.isNotEmpty(dto.getStatus())) {
				predicates.add(criteriaBuilder.equal(root.get("status"), dto.getStatus()));
			}

			if (StringUtils.isNotEmpty(dto.getYear())) {
				predicates.add(criteriaBuilder.equal(root.get("rentSlave").get("year"), dto.getYear()));
			}

			if (StringUtils.isNotEmpty(dto.getMobileNo())) {
				predicates.add(
						criteriaBuilder.like(root.get("shopowner").get("mobileNo"), "%" + dto.getMobileNo() + "%"));
			}

			if (StringUtils.isNotEmpty(dto.getReceiptNo())) {
				predicates.add(criteriaBuilder.like(root.get("receiptNo"), "%" + dto.getReceiptNo() + "%"));
			}

			if (dto.getReceiptDate() != null) {
				Calendar receiptDate = dto.getReceiptDate();

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String receiptDateString = dateFormat.format(receiptDate.getTime());

				predicates.add(
				criteriaBuilder.like(root.get("receiptDate").as(String.class), "%" + receiptDateString + "%"));
			}

			if (dto.getFromDate() != null && dto.getToDate() != null) {

				Calendar fromDate = dto.getFromDate();
				fromDate.set(Calendar.HOUR_OF_DAY, 0);
				fromDate.set(Calendar.MINUTE, 0);
				fromDate.set(Calendar.SECOND, 0);
				fromDate.set(Calendar.MILLISECOND, 0);

				Calendar toDate = dto.getToDate();
				toDate.set(Calendar.HOUR_OF_DAY, 23);
				toDate.set(Calendar.MINUTE, 59);
				toDate.set(Calendar.SECOND, 59);
				toDate.set(Calendar.MILLISECOND, 999);
				predicates.add(criteriaBuilder.between(root.get("created"), fromDate, toDate));
			}
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}

}
