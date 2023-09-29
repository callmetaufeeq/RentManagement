package com.tw.model;

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rent_slave")
@Where(clause = "deleted=false")
public class RentSlave extends AbstractPersistable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7672539885378528698L;

	@Column(name = "paid")
	private double paid;

	@Column(name = "remaining")
	private double remaining;
	
	@Column(name = "payment_type")
	private String paymentType;
	
	@Column(name = "year")
	private String year;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "rent_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private Rent rent;

}
