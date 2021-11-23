package com.shopping.shoppingbackend.payload.response;

public class UserProductCartResponse {
    private Long productId;
    private Integer numberOfItems;

    public Long getProductId() {
        return productId;
    }

    public UserProductCartResponse setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public UserProductCartResponse setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
        return this;
    }
}
