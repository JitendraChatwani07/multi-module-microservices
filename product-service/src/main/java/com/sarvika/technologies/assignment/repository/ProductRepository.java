package com.sarvika.technologies.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.sarvika.technologies.assignment.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
