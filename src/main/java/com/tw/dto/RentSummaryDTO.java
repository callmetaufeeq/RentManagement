package com.tw.dto;

public class RentSummaryDTO {

	private Double paid;
	private Double amount;
	private Double remaining;
	private String year;
	private String ownerName;
	private String shopName;

	public RentSummaryDTO(Double paid, Double amount, Double remaining, String year, String ownerName,
			String shopName) {
		this.paid = paid;
		this.amount = amount;
		this.remaining = remaining;
		this.year = year;
		this.ownerName = ownerName;
		this.shopName = shopName;
	}

	public Double getPaid() {
		return paid;
	}

	public void setPaid(Double paid) {
		this.paid = paid;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getRemaining() {
		return remaining;
	}

	public void setRemaining(Double remaining) {
		this.remaining = remaining;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

}
