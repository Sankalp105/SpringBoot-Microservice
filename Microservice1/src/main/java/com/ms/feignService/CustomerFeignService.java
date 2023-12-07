package com.ms.feignService;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PRODUCT-SERVICE")
//@FeignClient(value="demo1", url="http://localhost:2222/demo")
public interface CustomerFeignService {

	@GetMapping("demo1/productsC/{id}")
	Object getProductsByCategoryId(@PathVariable int id);
	
	@GetMapping("demo1/products")
	List<Object> getProducts();
	
	@GetMapping("demo1/products/{id}")
	Object getProduct(@PathVariable int id);

	@PostMapping("demo1/addProduct")
	Object addProduct(@RequestBody Object object);

	@PostMapping("demo1/addCategory")
	String addCategory(@RequestBody Object object);

}