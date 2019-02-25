package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.yash.model.Payment;
import com.yash.service.PaymentService;

@RestController
@RequestMapping("pay")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;

	// =========================================================== Get The All Payment Mode =================================

	@GetMapping
	public ResponseEntity<List<Payment>> getAllPaymentMode() {
		List<Payment> payment = paymentService.modeOfPayment();
		if (payment == null || payment.isEmpty()) {
			return new ResponseEntity<List<Payment>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Payment>>(payment, HttpStatus.OK);
	}

	/*// =================================================== Get Payment By the Id =================================

	@GetMapping("{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("id") int id) {
		Payment payment = paymentService.getPayment(id);
		if (payment == null) {
			return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Payment>(HttpStatus.OK);
	}

	// ======================================= Creating new Payment Mode ===================================

	@PostMapping
	public ResponseEntity<Void> addNewPayments(@RequestBody Payment payment, UriComponentsBuilder ucBuilder) {

		if (paymentService.exists(payment)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		paymentService.paymentMode(payment);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/payments/{id}").buildAndExpand(payment.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteExistingPayementMode(@PathVariable("id") int id) {

		Payment payment = paymentService.getPayment(id);

		if (payment == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		paymentService.removePaymentMode(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}*/

}
