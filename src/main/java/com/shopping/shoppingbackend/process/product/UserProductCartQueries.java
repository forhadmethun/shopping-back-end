package com.shopping.shoppingbackend.process.product;

import com.shopping.shoppingbackend.db.services.UserProductCartService;
import com.shopping.shoppingbackend.payload.response.UserProductCartResponse;
import com.shopping.shoppingbackend.util.Builders;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserProductCartQueries {
    private final UserProductCartService service;

    public UserProductCartQueries(UserProductCartService service) {
        this.service = service;
    }

    public List<UserProductCartResponse> findByUserId(Long userId) {
        return service.findByUserId(userId)
            .stream().map(Builders::build)
            .collect(Collectors.toList());
    }
}
