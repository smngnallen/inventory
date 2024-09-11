package com.demo.controller;

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

import com.demo.entity.Product;
import com.demo.service.ProductService;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return productService.addProducts(products);
	}

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{productID}")
	public Product getProductById(@PathVariable int productID) {
		return productService.getProductById(productID);
	}

	@PutMapping("/{productID}")
	public Product updateProduct(@PathVariable int productID, @RequestBody Product productDetails) {
		return productService.updateProduct(productID, productDetails);
	}

	@DeleteMapping("/{productID}")
	public void deleteProduct(@PathVariable int productID) {
		productService.deleteProduct(productID);
	}
}
