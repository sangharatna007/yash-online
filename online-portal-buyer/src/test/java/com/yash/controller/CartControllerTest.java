
package com.yash.controller;


import static org.mockito.Matchers.any;

import java.nio.charset.Charset;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.yash.configuration.OnlinePortalBuyerApp;
import com.yash.model.Product;
import com.yash.serviceImpl.CartServiceImpl;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { OnlinePortalBuyerApp.class })
public class CartControllerTest {

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Mock
	private CartServiceImpl cartServiceImpl;

	private MockMvc mockmvc;

	@Before
	public void setup() {

	}

	@Test
	public void testCheckProductToCart() throws Exception {
		
		Mockito.when(cartServiceImpl.addProductToCart(any(Product.class))).thenReturn(new HashMap<Product, Integer>());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(new Product(1,"Mobile", 10, 10000.00,1,1,1));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/cart/products").contentType(APPLICATION_JSON_UTF8)
				.content(json);
		MvcResult result = mockmvc.perform(requestBuilder).andReturn();
		System.out.println("mock result " + result.getResponse().getStatus());

	}

	@Test
	public void testRemoveProductToCart() {

	}

	@Test
	public void testAddProductToCart() {

	}

}
