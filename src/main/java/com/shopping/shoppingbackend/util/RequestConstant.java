package com.shopping.shoppingbackend.util;

public class RequestConstant {
    private RequestConstant(){
    }

    public static final String INVALID_INPUT = "Invalid Input";
    public static final String MISSING_USER_ID = "id cannot be negative";
    public static final String MISSING_PRODUCT_ID = "token is invalid";
    public static final String MISSING_NUMBER_OF_ITEMS = "Plan id is invalid";
    public static final String PRODUCT_NOT_EXISTS = "Product not exists";
    public static final String PRODUCT_NOT_EXISTS_IN_CART = "Product not exists in cart";
    public static final String SHOULD_BE_LESS_THAN_AVAILABLE_PRODUCT =
        "Request product number should be less than available product number";


}
