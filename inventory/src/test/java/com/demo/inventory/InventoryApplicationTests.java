package com.demo.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.entity.Product;
import com.demo.repository.ProductRepository;
import com.demo.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { InventoryApplicationTests.class })
class InventoryApplicationTests {

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductService productService;

	@Test
	public void testAddProduct() {
		Product product = new Product();
		product.setId(101);
		product.setName("Lenovo");
		product.setDesc("Chromebook");
		product.setType("Laptop");
		product.setQuantity(50);
		product.setPrice(39000);
		productRepository.save(product);

		Product result = productService.getProductById(101);

		assertEquals("Lenovo", result.getName());
		assertEquals(39000, result.getPrice());
	}

	@Test
	public void testAddProducts() {
		Product product = new Product();
		product.setId(101);
		product.setName("Lenovo");
		product.setDesc("Chromebook");
		product.setType("Laptop");
		product.setQuantity(50);
		product.setPrice(39000);
		productRepository.save(product);

		Product result = productService.getProductById(101);

		assertEquals("Lenovo", result.getName());
		assertEquals(39000, result.getPrice());
	}

	@Test
	public void testDeleteProduct() {
		productService.deleteProduct(101);
		Product product = productService.getProductById(101);

		assertEquals(product, null);
	}

	@Test
	public void testUpdateProduct() {
		Product product = new Product();
		product = productService.getProductById(102);
		Product updatedProduct = new Product();
		updatedProduct.setName("Dell");
		updatedProduct.setDesc("Gaming");
		updatedProduct.setType("Laptop");
		updatedProduct.setQuantity(100);
		updatedProduct.setPrice(45000);

		Product result = productService.updateProduct(product.getProductID(), updatedProduct);

		assertEquals("Dell", result.getName());
		assertEquals(10, result.getQuantity());
	}
}
