package com.yash.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.yash.model.Payment;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Payment> modeOfPayments() {
		List<Payment> modePaymentList = jdbcTemplate.query("SELECT * FROM payment",
				new BeanPropertyRowMapper(Payment.class));
		return modePaymentList;
	}

	public void paymentMode(Payment payment) {
		jdbcTemplate.update("INSERT INTO payment (id, typeOfPayment) VALUES (?, ?)", payment.getId(),
				payment.getTypeOfPayment());

	}

	public void removePaymentMode(int id ) {
		
		jdbcTemplate.update("DELETE from payment WHERE id = ? ", id);
		

	}

}
