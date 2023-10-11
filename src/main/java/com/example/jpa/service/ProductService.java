package com.example.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.entity.Product;
import com.example.jpa.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product addProduct(Product product) {
		return productRepository.save(product);

	}

	public Product getProduct(int id) {
		return productRepository.findById(id).get();
	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product updateProduct(Product productRequest) {
		return productRepository.save(productRequest);
	}

	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "product deleted";
	}

}