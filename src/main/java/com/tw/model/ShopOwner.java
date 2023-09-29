package com.tw.model;

import java.sql.Date;

import org.hibernate.annotations.Where;

import com.tw.generics.AbstractPersistable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shop_owner")
@Where(clause = "deleted=false")
public class ShopOwner extends AbstractPersistable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "mobile_number")
	private String mobileNo;

	@Column(name = "address")
	private String address;

	@Column(name = "for_work")
	private String forWork;

	@Column(name = "status")
	private int status=1;

	@Column(name = "date")
	private Date date;

	@OneToOne
	private Shop shop;
	
	@Column(name = "year")
	private Date year;
	
}
