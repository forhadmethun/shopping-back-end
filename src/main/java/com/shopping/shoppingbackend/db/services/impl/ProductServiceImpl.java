package com.shopping.shoppingbackend.db.services.impl;

import com.shopping.shoppingbackend.db.repository.ProductRepository;
import com.shopping.shoppingbackend.db.services.ProductService;
import com.shopping.shoppingbackend.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> find(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
