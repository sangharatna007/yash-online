package com.yash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yash.dao.PaymentDao;
import com.yash.model.Payment;

@Service("paymentService")
@Qualifier("paymentDao")
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentDao paymentDao;

	public List<Payment> modeOfPayment() {

		return paymentDao.modeOfPayment();
	}

	public void addPaymentMode(Payment payment) {
		paymentDao.addPaymentMode(payment);
	}

	public void deletePaymentMode(int id) {
		paymentDao.deletePaymentMode(id);

	}

}
