package com.yash.service;

import java.util.List;

import com.yash.model.Payment;

public interface PaymentService {

	public List<Payment> modeOfPayment();

	public void paymentMode(Payment payment);
	
	public void removePaymentMode(int id);
}
