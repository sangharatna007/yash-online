package com.yash.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.configuration.OnlineYashApp;

@RestController
@RequestMapping("user/")

public class Controller {
	private static final Logger log=Logger.getLogger(OnlineYashApp.class);
	
	@RequestMapping("/xyz")
	public  void test(Principal user) {
		log.info("in test controller "+user.getName());

	}
}
