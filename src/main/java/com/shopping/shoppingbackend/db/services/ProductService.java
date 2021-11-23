package com.shopping.shoppingbackend.db.services;

import com.shopping.shoppingbackend.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product save(Product product);

    Optional<Product> find(Long id);

    List<Product> findAll();

}
