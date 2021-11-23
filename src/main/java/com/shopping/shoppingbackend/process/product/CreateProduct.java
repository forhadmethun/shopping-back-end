package com.shopping.shoppingbackend.process.product;

import com.shopping.shoppingbackend.db.services.ProductService;
import com.shopping.shoppingbackend.payload.request.ProductRequest;
import com.shopping.shoppingbackend.payload.response.ProductResponse;
import org.springframework.stereotype.Component;

import static com.shopping.shoppingbackend.util.Builders.build;

@Component
public class CreateProduct {
    private final ProductService productService;

    public CreateProduct(ProductService productService) {
        this.productService = productService;
    }

    public ProductResponse create(ProductRequest productRequest) {
        return build(productService.save(build(productRequest)));
    }
}
