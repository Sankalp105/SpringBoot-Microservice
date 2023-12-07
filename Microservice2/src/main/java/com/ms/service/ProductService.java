package com.ms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ms.entity.Category;
import com.ms.entity.Products;
import com.ms.exception.CategoryAlreadyExistsException;
import com.ms.repository.CategoryRepository;
import com.ms.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;

	@Autowired
	CategoryRepository repository2;

	public List<Category> getCategories() {
		return repository2.findAll();
	}

	public List<Products> getProducts() {
		List<Products> list = repository.findAll();
		System.out.println(list);
		return list;
	}

	public Products getProductById(int id) {
		return repository.findById(id).orElse(null);
	}

	public Category getProductsByCategoryId(int id) {
		Category category = repository2.findById(id);
		return category;
	}

	public Products addProduct(Products product) {
		return repository.save(product);
	}

	public String addCategory(Category category) {
		Category existingCategory = repository2.findById(category.getId());
		if (existingCategory == null) {
			repository2.save(category);
			return "Category added successfully";
		} else {
			throw new CategoryAlreadyExistsException("Category already exists");
		}
	}

}
