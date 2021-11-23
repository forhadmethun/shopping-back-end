package com.shopping.shoppingbackend.db.services.impl;

import com.shopping.shoppingbackend.db.repository.UserProductCartRepository;
import com.shopping.shoppingbackend.db.services.UserProductCartService;
import com.shopping.shoppingbackend.models.UserProductCart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProductCartServiceImpl implements UserProductCartService {
    private final UserProductCartRepository repository;

    public UserProductCartServiceImpl(UserProductCartRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserProductCart save(UserProductCart userProductCart) {
        return repository.save(userProductCart);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<UserProductCart> findByUserIdAndProductId(Long userId, Long productId) {
        return repository.findByUserIdAndProductId(userId, productId);
    }

    @Override
    public List<UserProductCart> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
}
