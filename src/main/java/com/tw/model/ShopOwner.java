package com.tw.model;

import java.util.List;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tw.generics.AbstractPersistable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
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
	private static final long serialVersionUID = -822321045852409422L;

	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "mobile_number")
	private String mobileNo;

	@Column(name = "address")
	private String address;

	@OneToMany(mappedBy = "shopOwner", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	//@JsonIgnore
	private List<ShopOwnerSlave> shopownerSlave;

}
