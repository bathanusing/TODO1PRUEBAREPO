package com.todo1.hulkstore.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo1.hulkstore.dto.Product;
import com.todo1.hulkstore.entity.ProductMvDc;
import com.todo1.hulkstore.services.ProductServices;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	private static ProductMvDc product;

	private static Product productDto;
	@MockBean
	ProductServices services;
	
	 private static List<Product> productDtoList;
	 private static List<ProductMvDc> productList;
	
	@BeforeAll
	  public static void setUp() {
	    try {
	    	productDto = new Product(15, "figura de accion", new BigDecimal(12), "Figura nueva", 10);
	    	product = new ProductMvDc(productDto);
	    	productDtoList = new ArrayList<>();
	    	productList = new ArrayList<>();
	    	productDtoList.add(productDto);
	    	productList.add(product);
		    } catch (Exception e) {
		    }
	    }
	@WithMockUser(username = "andres", password = "clave3")
	@Test
	public void retrieveAllProducts() throws Exception {
		doReturn(productList).when(services).findAll();
		this.mockMvc.perform(get("/findAll"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(mapToJson(productList))));
		
	}
	
	private String mapToJson(Object obj) throws JsonProcessingException {
	    ObjectMapper objectMapper = new ObjectMapper();
	    return objectMapper.writeValueAsString(obj);
	  }
}
