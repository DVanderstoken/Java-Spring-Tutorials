package com.fms.tutotrials.jpa.auditing.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fms.tutotrials.jpa.auditing.model.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration
@ContextConfiguration(classes = { ProductRepository.class })
@EntityScan(basePackages = { "com.fms.tutotrials.jpa.auditing.model" })
@DataJpaTest
@EnableJpaAuditing
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductRepositoryTest extends BaseRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private ProductRepository repository;

	@Test
	@Order(value = 10)
	void contextLoads() {
		assertNotNull(repository, "Repository should be correctly injected");
		assertNotNull(testEntityManager, "Test entity manager should be correctly injected");
	}

	@Test
	@Order(value = 20)
	void productCreationShouldReturnCreatedProduct() {
		Product p = randomProduct();
		Product created = repository.save(p);
		
		assertNotNull(created);
		assertNotNull(created.getId());
		assertEquals(p.getName(), created.getName());
	}

	@Test
	@Order(value = 30)
	void anotherProductCreationShouldReturnCreatedProduct() {
		Product p = randomProduct();
		
		Product created = testEntityManager.persist(p);
		testEntityManager.flush();
		testEntityManager.clear();
		
		Product searched = testEntityManager.find(Product.class, created.getId());

		assertNotNull(created);
		assertNotNull(created.getId());
		
		assertNotNull(searched);
		assertNotNull(searched.getId());
		
		assertEquals(p.getName(), created.getName());
		assertEquals(p.getName(), searched.getName());
		assertEquals(searched.getName(), created.getName());
	}
	
	@Test
	@Order(value = 40)
	void manyProductCreationShouldReturnCreatedProducts() {
		
		int count = 11;
		
		manyRandomProducts(count).forEach(product ->{
			Product created = testEntityManager.persist(product);
			
			assertNotNull(created);
			
			testEntityManager.flush();
			testEntityManager.clear();
		});
		
		repository.findAll().forEach(Assertions::assertNotNull);
		
	}
	
	@Test
	@Order(value = 50)
	void deletedProductsShouldNotBeRetrievedAsActive() {
		
		int count = 11 ;
		
		manyRandomProducts(count).forEach(product -> {
			repository.save(product);
		});
		
		long  randomIdBetween1AndCount = Long.valueOf(easyRandom.nextInt(count) + 1);
		
		Optional<Product> toBeDeleted = repository.findById(randomIdBetween1AndCount);
		
		if (toBeDeleted.isPresent()) {
			
			repository.delete(toBeDeleted.get());
			
			long size = StreamSupport.stream(repository.findAll().spliterator(), false).count();

			assertEquals(size,  count -1);
		}
		
		Optional<Product> deleted = repository.findById(randomIdBetween1AndCount);
		
		assertTrue(deleted.isEmpty());
		
	}

}
