package com.shopping.shoppingbackend.db.repository;

import com.shopping.shoppingbackend.models.UserProductCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProductCartRepository extends JpaRepository<UserProductCart, Long> {

    Optional<UserProductCart> findByUserIdAndProductId(Long userId, Long productId);

    List<UserProductCart> findByUserId(Long userId);

}
