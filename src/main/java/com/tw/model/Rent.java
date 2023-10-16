package com.tw.model;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tw.generics.AbstractPersistable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity	
@Table(name = "rent")
@Where(clause = "deleted=false")
public class Rent extends AbstractPersistable {
	/**
	 * SHAIKH SOHEL
	 */
	private static final long serialVersionUID = 1L;

	
	@Column(name = "total_rent_amount")
	private double totalRentAmount;
	
	@Column(name = "total_deposit_amount")
	private double totalDepositAmount;

	@Column(name = "total_paid")
	private double totalPaid;

	@Column(name = "total_remaining")
	private double totalRemaining;

	@Column(name = "receipt_date")
	private Date receiptDate;

	@Column(name = "status")
	private String status;

	@Column(name = "receipt_no")
	private String receiptNo;
	
	@Column(name = "year")
	private String year;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "user_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "shopowner_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private ShopOwner shopowner;

	@OneToMany(mappedBy = "rent", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JsonIgnore
	private List<RentSlave> rentSlave;
	
}
