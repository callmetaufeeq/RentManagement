package com.tw.model;

import java.util.Date;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tw.generics.AbstractPersistable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "shop")
@Where(clause = "deleted=false")
public class Shop extends AbstractPersistable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "category_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private Category category;

	@Column(name = "shop_name")
	private String shopName;

	@Column(name = "rent")
	private double rent;

	@Column(name = "address")
	private String address;

	@Column(name = "join_date")
	private Date joinDate;

	@Column(name = "rent_type")
	private String rentType;

	@Column(name = "status")
	private int status = 1;

	@Column(name = "rented")
	private int rented = 0;
	
	@Column(name = "shop_code")
	private String shopCode;

	
}
