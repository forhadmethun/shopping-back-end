package com.shopping.shoppingbackend.util;

import com.shopping.shoppingbackend.models.Product;
import com.shopping.shoppingbackend.models.UserProductCart;
import com.shopping.shoppingbackend.payload.request.ProductRequest;
import com.shopping.shoppingbackend.payload.request.UserProductAddToCartRequest;
import com.shopping.shoppingbackend.payload.response.ProductResponse;
import com.shopping.shoppingbackend.payload.response.UserProductCartResponse;

public class Builders {
    private Builders() {
        throw new IllegalStateException("Utility class");
    }

    public static Product build(ProductRequest productRequest) {
        return new Product()
            .setName(productRequest.getName())
            .setDescription(productRequest.getDescription())
            .setColor(productRequest.getColor())
            .setRank(productRequest.getRank())
            .setPrice(productRequest.getPrice())
            .setNumberOfAvailableItems(productRequest.getNumberOfAvailableItems());
    }

    public static ProductResponse build(Product product) {
        return new ProductResponse()
            .setId(product.getId())
            .setName(product.getName())
            .setDescription(product.getDescription())
            .setColor(product.getColor())
            .setRank(product.getRank())
            .setPrice(product.getPrice())
            .setNumberOfAvailableItems(product.getNumberOfAvailableItems());
    }

    public static UserProductCart build(UserProductAddToCartRequest request) {
        return new UserProductCart()
            .setUserId(request.getUserId())
            .setProductId(request.getProductId())
            .setNumberOfItems(request.getNumberOfItems());
    }

    public static UserProductCartResponse build(UserProductCart userProductCart) {
        return new UserProductCartResponse()
            .setProductId(userProductCart.getProductId())
            .setNumberOfItems(userProductCart.getNumberOfItems());
    }
}
