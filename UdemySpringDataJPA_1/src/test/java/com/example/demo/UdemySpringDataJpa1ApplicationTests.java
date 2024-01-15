package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.model.Product;

@SpringBootTest
class UdemySpringDataJpa1ApplicationTests {

	
	@Autowired
	ProductRepository productRepository;
	
	
	
	@Test
	void saveMethod() {
		
		Product product = new Product();
		product.setActive(true);
		product.setDescription("product one description");
		product.setImageUrl("product1.png");
		product.setPrice(new BigDecimal(100));
		product.setSku("100ABC");
		product.setName("Product1");
		
		Product saveProduct = productRepository.save(product);
		
		System.out.println(saveProduct.getId());
		System.out.println(saveProduct.toString());
		
		
	}
	
	
	@Test
	void updateMethod() {
		Long id = 1L;
		Product product = productRepository.findById(id).get();
		
		product.setName("updated product 1");
		product.setDescription("updated product 1 desc");
		
		productRepository.save(product);
		
	}
	
	@Test
	void findByIdMethod() {
		Long id = 1L;
		Product product = productRepository.findById(id).get();
	}
	
	@Test
	void saveAllMethod() {
		Product product2 = new Product();
		product2.setActive(true);
		product2.setDescription("product two description");
		product2.setImageUrl("product2.png");
		product2.setPrice(new BigDecimal(100));
		product2.setSku("ABC111");
		product2.setName("Product2");
		
		Product product3 = new Product();
		product3.setActive(true);
		product3.setDescription("product two description");
		product3.setImageUrl("product2.png");
		product3.setPrice(new BigDecimal(100));
		product3.setSku("ABCef");
		product3.setName("Product3");
		List<Product> list = new ArrayList<>();
		list.add(product2);
		list.add(product3);
		productRepository.saveAll(list);
	}
	
	
	@Test
	void findAllMethod() {
		List<Product> products = productRepository.findAll();
		
		products.forEach(p->{
			System.out.println(p.getName());
		});
	}
	
	@Test
	void deleteByIdMethod() {
		Long id =4L;
		productRepository.deleteById(id);
	}
	
	@Test
	void deleteMethod() {
		Long id = 3L;
		
		Optional<Product> byId = productRepository.findById(id);
		Product product = productRepository.findById(id).get();
		//delete the entity
		
		productRepository.delete(product);
	}
	
	@Test
	void deleteAllMethod() {
		 Product product = productRepository.findById(10L).get();
		 Product product1 = productRepository.findById(11L).get();
		
		productRepository.deleteAll(List.of(product,product1));
	}
	
	@Test
	void CountMethod() {
		long count = productRepository.count();
		System.out.println(count);
	}
	
	@Test
	void existByIdMethod() {
		boolean id = productRepository.existsById(9L);
		System.out.println(id);
	}
}
