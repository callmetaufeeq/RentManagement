package com.tw.dto;

public class CategoryDto {

	private String shopName;
	private double amount;
	private double paid;
	private double remaining;
	private String categoryName;
	private String ownerName;

	public CategoryDto(String categoryName, String ownerName, String shopName, double amount, double paid,
			double remaining) {
		super();
		this.categoryName = categoryName;
		this.ownerName = ownerName;
		this.shopName = shopName;
		this.amount = amount;
		this.paid = paid;
		this.remaining = remaining;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

}
