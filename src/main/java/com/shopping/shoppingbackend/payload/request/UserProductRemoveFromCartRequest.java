package com.shopping.shoppingbackend.payload.request;

public class UserProductRemoveFromCartRequest {
    private Long userId;
    private Long productId;
    private Integer numberOfItems;

    public Long getUserId() {
        return userId;
    }

    public UserProductRemoveFromCartRequest setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getProductId() {
        return productId;
    }

    public UserProductRemoveFromCartRequest setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public UserProductRemoveFromCartRequest setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
        return this;
    }
}
