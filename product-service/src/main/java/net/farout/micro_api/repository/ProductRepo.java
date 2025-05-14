package net.farout.micro_api.repository;

import net.farout.micro_api.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product, String> {
}
