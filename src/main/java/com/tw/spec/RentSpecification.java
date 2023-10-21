package com.tw.spec;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.tw.model.Rent;

import jakarta.persistence.criteria.Predicate;

public class RentSpecification {

    public static Specification<Rent> buildSpecification(RentSpecDto dto) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(dto.getShopownerName())) {
            	predicates.add(criteriaBuilder.like(root.get("shopowner").get("ownerName"),
						"%" + dto.getShopownerName() + "%"));
            }

            if (StringUtils.hasText(dto.getShopName())) {
            	predicates.add(criteriaBuilder.like(root.get("rentSlave").get("shop").get("shopName"),
						"%" + dto.getShopName() + "%"));
            }

            if (StringUtils.hasText(dto.getStatus())) {
                predicates.add(criteriaBuilder.equal(root.get("status"), dto.getStatus()));
            }

            if (StringUtils.hasText(dto.getYear())) {
            	predicates.add(criteriaBuilder.equal(root.get("rentSlave").get("year"),
						 dto.getYear() ));
            }
            
            if (StringUtils.hasText(dto.getShopownerName())) {
            	predicates.add(criteriaBuilder.like(root.get("shopowner").get("mobileNo"),
						"%" + dto.getMobileNo() + "%"));
            }
            
            if (StringUtils.hasText(dto.getShopownerName())) {
            	predicates.add(criteriaBuilder.like(root.get("rent").get("receiptNo"),
						"%" + dto.getReceiptNo() + "%"));
            }
            
            if (StringUtils.hasText(dto.getShopownerName())) {
            	predicates.add(criteriaBuilder.like(root.get("rent").get("receiptDate"),
						"%" + dto.getReceiptDate() + "%"));
            }
            
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
