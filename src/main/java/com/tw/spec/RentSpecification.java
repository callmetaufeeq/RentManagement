package com.tw.spec;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;


import com.tw.model.Rent;

import jakarta.persistence.criteria.Predicate;

public class RentSpecification {

	public static Specification<Rent> buildSpecification(RentSpecDto dto) {
		
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

			if (StringUtils.isNotEmpty(dto.getShopownerName())) {
				predicates.add(
						criteriaBuilder.like(root.get("shopowner").get("mobileNo"), "%" + dto.getMobileNo() + "%"));
			}

			if (StringUtils.isNotEmpty(dto.getShopownerName())) {
				predicates.add(criteriaBuilder.like(root.get("receiptNo"), "%" + dto.getReceiptNo() + "%"));
			}

			if (dto.getReceiptDate()!=null) {
				predicates.add(
						criteriaBuilder.like(root.get("receiptDate"), "%" + dto.getReceiptDate() + "%"));
			}

			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
