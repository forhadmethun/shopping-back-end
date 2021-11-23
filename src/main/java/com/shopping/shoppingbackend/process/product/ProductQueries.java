package com.shopping.shoppingbackend.process.product;

import com.shopping.shoppingbackend.db.services.ProductService;
import com.shopping.shoppingbackend.payload.response.ProductResponse;
import com.shopping.shoppingbackend.util.Builders;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductQueries {
    private final ProductService productService;

    public ProductQueries(ProductService productService) {
        this.productService = productService;
    }

    public List<ProductResponse> findAll() {
        return productService.findAll()
            .stream().map(Builders::build)
            .collect(Collectors.toList());
    }
}
