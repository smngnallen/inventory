package com.demo.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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

	private Product product;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		product = new Product();
		product = productService.getProductById(1);
	}

	@Test
	public void testUpdateProduct() {
		Product updatedProduct = new Product();
		updatedProduct.setProductName("Updated Laptop");
		updatedProduct.setProductDescription("Updated Gaming Laptop");
		updatedProduct.setProductType("electronic");
		updatedProduct.setProductQuantity(10);
		updatedProduct.setProductPrice(1500);

		Product result = productService.updateProduct(product.getProductID(), updatedProduct);

		assertEquals("Updated Laptop", result.getProductName());
		assertEquals(10, result.getProductQuantity());
	}
}
