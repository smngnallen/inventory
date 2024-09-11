package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Product;
import com.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> addProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}

	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}

	public Product updateProduct(int id, Product details) {
		Product product = getProductById(id);
		product.setProductName(details.getProductName());
		product.setProductDescription(details.getProductDescription());
		product.setProductType(details.getProductType());
		product.setProductQuantity(details.getProductQuantity());
		product.setProductPrice(details.getProductPrice());
		return productRepository.save(product);
	}
}
