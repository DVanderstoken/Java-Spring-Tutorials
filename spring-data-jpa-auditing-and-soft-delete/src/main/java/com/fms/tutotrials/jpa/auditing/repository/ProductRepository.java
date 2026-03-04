package com.fms.tutotrials.jpa.auditing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fms.tutotrials.jpa.auditing.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
