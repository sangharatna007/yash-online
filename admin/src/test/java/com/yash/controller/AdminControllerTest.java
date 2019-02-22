package com.yash.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.yash.model.Category;
import com.yash.service.CategoryServiceImpl;

public class AdminControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private CategoryServiceImpl categorieService;

	@InjectMocks
	AdminController controller = new AdminController();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void test_get_all_success() throws Exception {
		List<Category> categoris = Arrays.asList(new Category(1, "Electronics"), new Category(2, "Furntitures"));

		when(categorieService.getAllCategories()).thenReturn(categoris);

		mockMvc.perform(get("/categories")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$[0].categoryId", is(1)))
				.andExpect(jsonPath("$[0].categoryTitle", is("Electronics")))
				.andExpect(jsonPath("$[1].categoryId", is(2)))
				.andExpect(jsonPath("$[1].categoryTitle", is("Furntitures")));

		verify(categorieService, times(1)).getAllCategories();
		verifyNoMoreInteractions(categorieService);
	}

}
