package com.yash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yash.dao.PaymentDao;
import com.yash.model.Payment;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentDao paymentDao;

	public List<Payment> modeOfPayment() {

		return paymentDao.modeOfPayments();
	}

	public void paymentMode(Payment payment) {
		paymentDao.paymentMode(payment);
	}

	public void removePaymentMode(int id) {
		paymentDao.removePaymentMode(id);

	}

	public Payment getPayment(int id) {
		
		return paymentDao.getPayment(id);
	}

	public boolean exists(Payment payment) {
		// TODO Auto-generated method stub
		return false;
	}

}
