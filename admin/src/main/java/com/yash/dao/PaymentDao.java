package com.yash.dao;

import java.util.List;

import com.yash.model.Payment;

public interface PaymentDao {

	public List<Payment> modeOfPayment();

	public void addPaymentMode(Payment payment);
	
	public void deletePaymentMode(int id);

}
