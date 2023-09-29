package com.tw.dto;

public class RentYearOwnerId {

	private double amount;
	private double paidAmount;
	private double remainingAmount;
	
	public RentYearOwnerId(double amount, double paidAmount, double remainingAmount) {
		super();
		this.amount = amount;
		this.paidAmount = paidAmount;
		this.remainingAmount = remainingAmount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public double getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
	
	
}
