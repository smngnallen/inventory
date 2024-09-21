package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Product;
import com.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public Product addProduct(Product product) {
		return repo.save(product);
	}

	public List<Product> addProducts(List<Product> products) {
		return repo.saveAll(products);
	}

	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	public Product getProductById(int id) {
		return repo.findById(id).orElse(null);
	}

	public void deleteProduct(int id) {
		repo.deleteById(id);
	}

	public Product updateProduct(int id, Product details) {
		Product product = getProductById(id);
		product.setName(details.getName());
		product.setDesc(details.getDesc());
		product.setType(details.getType());
		product.setQuantity(details.getQuantity());
		product.setPrice(details.getPrice());
		return repo.save(product);
	}
}
