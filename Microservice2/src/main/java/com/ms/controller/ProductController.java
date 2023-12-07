package com.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.entity.Category;
import com.ms.entity.Products;
import com.ms.exception.CategoryAlreadyExistsException;
import com.ms.exception.ErrorResponse;
import com.ms.service.ProductService;

@RestController
@RequestMapping("/demo1")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/getCategory")
	public ResponseEntity<List<Category>> getCategories(){
		List<Category> list=service.getCategories();
		return new ResponseEntity<List<Category>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Products>> getAllProducts(){
		List<Products> pList = service.getProducts();
		return new ResponseEntity<List<Products>>(pList,HttpStatus.OK);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Products> getProduct(@PathVariable int id){
		Products product = service.getProductById(id);
		return new ResponseEntity<Products>(product,HttpStatus.OK);
	}
	
	@GetMapping("/productsC/{id}")
    public ResponseEntity<Category> getProductsByCategory(@PathVariable int id) {
		Category category= service.getProductsByCategoryId(id);
		return new ResponseEntity<Category>(category,HttpStatus.OK);
	}
	
	@PostMapping("/addProduct")
	public ResponseEntity<Products> addProduct(@RequestBody Products product) {
		Products addProduct = service.addProduct(product);
		return new ResponseEntity<Products>(addProduct, HttpStatus.OK);
	}
		
	@PostMapping("/addCategory")
	public String addCategory(@RequestBody Category category ) {
		return service.addCategory(category);	
	}
	
	@ExceptionHandler(value=CategoryAlreadyExistsException.class)
    public ErrorResponse handleCategoryAlreadyExistsException(CategoryAlreadyExistsException ex)
    {
        return new ErrorResponse("ERR-CAT-EXISTS-001",ex.getMessage());
    }

	}
	
    

