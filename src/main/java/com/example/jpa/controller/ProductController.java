package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Product;
import com.example.jpa.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable int id) {
		return service.getProduct(id);
	}

	@GetMapping
	public List<Product> getProducts() {
		return service.getProducts();
	}

	@PutMapping
	public Product updateProduct(@RequestBody Product productRequest) {
		return service.updateProduct(productRequest);
	}

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}

}
