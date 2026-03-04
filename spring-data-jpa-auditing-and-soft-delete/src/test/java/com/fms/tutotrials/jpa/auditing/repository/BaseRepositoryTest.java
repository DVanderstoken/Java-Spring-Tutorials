package com.fms.tutotrials.jpa.auditing.repository;

import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

import com.fms.tutotrials.jpa.auditing.model.Product;

import net.datafaker.Faker;

public class BaseRepositoryTest {
	
	private final Faker faker = new Faker(Locale.FRANCE);
    protected EasyRandom easyRandom;

    public BaseRepositoryTest() {
        EasyRandomParameters parameters = new EasyRandomParameters().seed(System.currentTimeMillis())
                .stringLengthRange(5, 20);
        this.easyRandom = new EasyRandom(parameters);
    }
    
    public Product randomProduct() {
    	return Product.builder().name(faker.brand().car()).build();
    }
    
    public List<Product> manyRandomProducts(int count) {
    	return IntStream.range(0, count).mapToObj(index -> randomProduct()).toList();
    }


}
