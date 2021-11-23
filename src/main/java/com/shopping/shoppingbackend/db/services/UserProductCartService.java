package com.shopping.shoppingbackend.db.services;

import com.shopping.shoppingbackend.models.UserProductCart;

import java.util.List;
import java.util.Optional;

public interface UserProductCartService {

    UserProductCart save(UserProductCart userProductCart);

    void delete(Long id);

    Optional<UserProductCart> findByUserIdAndProductId(Long userId, Long productId);

    List<UserProductCart> findByUserId(Long userId);
}
