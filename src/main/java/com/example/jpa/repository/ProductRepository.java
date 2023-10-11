package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jpa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByProductType(String productType);

	@Query("from Product p where p.productType= ?1")
	List<Product> findByProduct(String productType);

	List<Product> findByPriceAndProductType(double price, String productType);

	List<Product> findByPriceIn(List<Double> price);

	List<Product> findByPriceBetween(double minPrice, double maxPrice);

	List<Product> findByPriceLessThan(double priceRange);

	List<Product> findByPriceGreaterThan(double priceRange);

	List<Product> findByNameIgnoreCaseContaining(String name);
}