package com.tw.model;

import java.util.Date;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop")
@Where(clause = "status= 1")
public class Shop {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "shop_name")
	private String nameofshop;

	@Column(name = "rent")
	private double rent;

	@Column(name = "address")
	private String address;

	@Column(name = "join_date")
	private Date joinDate;

	@Column(name = "status")
	private int status;

	@Column(name = "rented")
	private int rented = 0;

	public int getRented() {
		return rented;
	}

	public void setRented(int rented) {
		this.rented = rented;
	}

	@CreatedDate
	@Column(name = "created_date")
	private Date createdOn;

	@LastModifiedDate
	@Column(name = "last_modified_date")
	private Date lastModifiedTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameofshop() {
		return nameofshop;
	}

	public void setNameofshop(String nameofshop) {
		this.nameofshop = nameofshop;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;

	}

}
