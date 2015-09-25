package com.spring.sample.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.sample.dao.CategoryDAO;

import static org.mockito.Mockito.*;


public class HomePageControllerTest {
	
	@Test
	public void testHomePage() throws Exception {
		
		CategoryDAO cateoryDAO = mock(CategoryDAO.class);
		HomePageController homePageController = new HomePageController();
		homePageController.categoryDAO = cateoryDAO;
		
		MockMvc mockMvc = standaloneSetup(homePageController).build();
		mockMvc.perform(get("/")).andExpect(view().name("homepage/index"));
	}
}
