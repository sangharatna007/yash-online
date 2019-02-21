package com.yash.controller;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.yash.configuration.OnlinePortalAdminApp;
import com.yash.dao.CategoryDaoImpl;
import com.yash.model.Category;
import com.yash.service.CategoryServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { OnlinePortalAdminApp.class })
@WebAppConfiguration
public class AdminControllerTest {
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	
	@Mock 
	public CategoryServiceImpl categoryServiceImpl;
	
	@InjectMocks
	private AdminController controller;
	
	MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	
	@Test 
	public void categoriesShouldBeAdd throws Exception { 
		List<Category> listOfCategories = new ArrayList<>();
		
		Category category=new Category(1003,"Mobile"); 
		Category category1=new Category(1002,"TV");
		listOfCategories.add(category);
		listOfCategories.add(category1);
		
		
		Mockito.when(categoryServiceImpl.addCategory(any(Category.class))).thenReturn();
		
		
		Mockito.when(categoryServiceImpl.addCategory(any(Category.class))).thenReturn();       
		
		
		addProductToCart(any(Product.class))).thenReturn(productMap);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter(); 
		String toBeCompareJson = ow.writeValueAsString(productMap).replace(" ", "").replace("\n", "").replace("\r", ""); 
		String json = ow.writeValueAsString(product);
	  
		RequestBuilder requestBuilder = MockMvcRequestBuilders
											.post("/cart/products")
											.contentType(APPLICATION_JSON_UTF8)
											.content(json);
		MvcResult result = mockmvc.perform(requestBuilder).andReturn();
		System.out.println("mock result response code " + result.getResponse().getStatus());
		System.out.println("mock result response " + result.getResponse().getOutputStream());
		assertEquals(200, result.getResponse().getStatus());
		assertEquals(toBeCompareJson, result.getResponse().getContentAsString().replace(" ", ""));
	  
	  }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
