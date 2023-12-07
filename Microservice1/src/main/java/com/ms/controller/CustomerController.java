package com.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ms.feignService.CustomerFeignService;
@RestController
@RequestMapping("/demo")
public class CustomerController {

	@Autowired
	CustomerFeignService feignService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/products")
	public ResponseEntity<List<Object>> getProducts() {
		List<Object> list = feignService.getProducts();
		return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Object> getProduct(@PathVariable int id){
		Object object1= feignService.getProduct(id);
		return new ResponseEntity<Object>(object1,HttpStatus.OK);
	}
	
	@GetMapping("/productsC/{id}")
	public ResponseEntity<Object> getProductsByCategoryId(@PathVariable int id) {
		Object list = feignService.getProductsByCategoryId(id);
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
	
	@PostMapping("/addProduct")
	public ResponseEntity<Object> addProduct(@RequestBody Object object) {
		Object object1 = feignService.addProduct(object);
		return new ResponseEntity<Object>(object1, HttpStatus.OK);
	}
	
	@PostMapping("/addCategory")
	public ResponseEntity<String> addCategory(@RequestBody Object object){
		String object2 = feignService.addCategory(object);
		return new ResponseEntity<String>(object2,HttpStatus.OK);
	}
	
	@GetMapping("/getCategories")
	public ResponseEntity<Object> getCategory(){
		Object list=restTemplate.getForObject("http://localhost:2222/demo/getCategory", List.class);
		return new ResponseEntity<Object>(list,HttpStatus.OK);
		
	}
	
	
}
