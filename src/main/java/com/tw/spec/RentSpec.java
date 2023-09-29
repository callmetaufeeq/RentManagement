package com.tw.spec;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.tw.model.Rent;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


public class RentSpec implements Specification<Rent>{
	
	/**
	 * SHAIKH SOHEL
	 */
	private static final long serialVersionUID = 3700397600692949136L;
	
	private String shopownerName;
	private String shopName;
	private String status;
	private String year;
	
	public RentSpec(String shopownerName, String shopName, String status, String year) {
		super();
		this.shopownerName = shopownerName;
		this.shopName = shopName;
		this.status = status;
		this.year =year;
	}

	@Override
	public Predicate toPredicate(Root<Rent> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		Predicate con = cb.conjunction();
		
		if (StringUtils.isNotEmpty(this.shopownerName)) {
			con.getExpressions().add(cb.like(root.get("shopowner").get("ownerName"), "%" + this.shopownerName + "%"));
		}
		
		if(StringUtils.isNotEmpty(this.shopName)) {
			con.getExpressions().add(cb.like(root.get("shopowner").get("shop").get("shopName"), "%" + this.shopName + "%"));
		}
		if(StringUtils.isNotEmpty(this.status)) {
			con.getExpressions().add(cb.equal(root.get("status"),   this.status ));
		}
		
		if(StringUtils.isNotEmpty(this.year)) {
			con.getExpressions().add(cb.equal(root.get("year"),   this.year ));
		}
		return con;
	}

}
