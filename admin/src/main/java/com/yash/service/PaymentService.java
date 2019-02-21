package com.yash.service;

import java.util.List;

import com.yash.model.Payment;

public interface PaymentService {

	public List<Payment> modeOfPayment();

	public void addPaymentMode(Payment payment);
	
	public void deletePaymentMode(int id);
}
