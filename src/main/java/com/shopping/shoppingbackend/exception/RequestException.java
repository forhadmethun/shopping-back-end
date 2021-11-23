package com.shopping.shoppingbackend.exception;

public class RequestException extends Exception {
    public RequestException(String error) {
        super(error);
    }
}
