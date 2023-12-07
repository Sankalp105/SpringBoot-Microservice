package com.ms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ms.controller.ProductController;
import com.ms.entity.Products;
import com.ms.repository.ProductRepository;
import com.ms.service.ProductService;

@SpringBootTest
class Microservice2ApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	
	@MockBean
	ProductRepository repository;
	
//	@MockBean
//	ProductController controller;
	
	@Autowired
	ProductService service;
	
	@Test
	public void getProductsTest() {
		when(repository.findAll()).thenReturn(Stream.of(new Products(56,"Telivision",45000,512),new Products(57,"Telivision2",46000,513)).collect(Collectors.toList()));
		assertEquals(2, service.getProducts().size());;
	}
	
//	@Test
//	public void getProductsTest1() {
//		when(service.getProducts()).thenReturn(Stream.of(new Products(56,"Telivision",45000,512),new Products(57,"Telivision2",46000,513)).collect(Collectors.toList()));
//		assertEquals(2, service.getProducts().size());;
//	}
	
	

}
