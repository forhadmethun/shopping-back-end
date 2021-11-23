package com.shopping.shoppingbackend.payload.request;

public class UserProductAddToCartRequest {
    private Long userId;
    private Long productId;
    private Integer numberOfItems;

    public Long getUserId() {
        return userId;
    }

    public UserProductAddToCartRequest setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getProductId() {
        return productId;
    }

    public UserProductAddToCartRequest setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public UserProductAddToCartRequest setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
        return this;
    }
}
