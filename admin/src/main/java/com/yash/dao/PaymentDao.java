package com.yash.dao;

import java.util.List;

import com.yash.model.Payment;

public interface PaymentDao {

	public List<Payment> modeOfPayments();
	
	public Payment getPayment(int id);

	public void paymentMode(Payment payment);
	
	public void removePaymentMode(int id);
	
	public boolean exists(Payment payment);

}
