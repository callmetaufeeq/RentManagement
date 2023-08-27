package com.tw.model;

import java.sql.Date;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.LastModifiedDate;

import com.tw.generics.AbstractPersistable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rent")
//@Where(clause = "status = 1")
@Where(clause = "deleted=false")
public class Rent extends AbstractPersistable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private ShopOwner shopOwner;

	@Column(name = "amount")
	private double amount;

	@Column(name = "paid")
	private double paid;

	@Column(name = "remaining")
	private double remaining;

	@LastModifiedDate
	@Column(name = "date")
	private Date date;

	@ManyToOne
	private User user;

	@Column(name = "payment_type")
	private String paymentType;

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Column(name = "status")
	private int status;

	@Column(name = "year")
	private String year;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public ShopOwner getShopOwner() {
		return shopOwner;
	}

	public void setShopOwner(ShopOwner shopOwner) {
		this.shopOwner = shopOwner;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}

	public double getRemaining() {
		return remaining;
	}

	public void setRemaining(double remaining) {
		this.remaining = remaining;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
