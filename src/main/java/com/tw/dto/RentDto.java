package com.tw.dto;

public class RentDto {

	private double paid;
	private String year;
	private String paymentType;

	public RentDto(double paid, String year, String paymentType) {
		super();
		this.paid = paid;
		this.year = year;
		this.paymentType = paymentType;
	}

	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
