package com.yash.model;

import javax.validation.constraints.NotNull;

public class Payment {

	@NotNull
	private int id;

	@NotNull
	private String typeOfPayment;

	public Payment() {

	}

	public Payment(int id, String typeOfPayment) {
		super();
		this.id = id;
		this.typeOfPayment = typeOfPayment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeOfPayment() {
		return typeOfPayment;
	}

	public void setTypeOfPayment(String typeOfPayment) {
		this.typeOfPayment = typeOfPayment;
	}

	
	
}
