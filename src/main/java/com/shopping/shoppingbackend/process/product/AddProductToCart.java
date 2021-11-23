package com.shopping.shoppingbackend.process.product;

import com.shopping.shoppingbackend.db.services.ProductService;
import com.shopping.shoppingbackend.db.services.UserProductCartService;
import com.shopping.shoppingbackend.exception.RequestException;
import com.shopping.shoppingbackend.models.Product;
import com.shopping.shoppingbackend.models.UserProductCart;
import com.shopping.shoppingbackend.payload.request.UserProductAddToCartRequest;
import com.shopping.shoppingbackend.payload.request.UserProductRemoveFromCartRequest;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.shopping.shoppingbackend.util.Builders.build;
import static com.shopping.shoppingbackend.util.RequestConstant.*;
import static com.shopping.shoppingbackend.util.ValidateUtil.isNotNull;
import static com.shopping.shoppingbackend.util.ValidateUtil.isTrue;

@Component
@Transactional
public class AddProductToCart {
    private final ProductService productService;
    private final SimpMessagingTemplate template;
    private final UserProductCartService userProductCartService;

    public AddProductToCart(
        ProductService productService,
        SimpMessagingTemplate template,
        UserProductCartService userProductCartService) {
        this.productService = productService;
        this.template = template;
        this.userProductCartService = userProductCartService;
    }

    public void add(UserProductAddToCartRequest request) throws RequestException {
        Product product = validateAndReturnProduct(request);
        Optional<UserProductCart> userProductCart = userProductCartService
            .findByUserIdAndProductId(request.getUserId(), request.getProductId());
        addProductToCart(request, userProductCart);
        updateAvailableProduct(request, product);
        publishProductChangeMessage(product, request);
    }

    private void updateAvailableProduct(UserProductAddToCartRequest request, Product product) {
        product.setNumberOfAvailableItems(
            product.getNumberOfAvailableItems() - request.getNumberOfItems()
        );
        productService.save(product);
    }

    private void addProductToCart(
        UserProductAddToCartRequest request, Optional<UserProductCart> userProductCart) {
        userProductCartService.save(
            userProductCart.isEmpty()
                ? build(request) :
                userProductCart.get().setNumberOfItems(
                    userProductCart.get().getNumberOfItems() + request.getNumberOfItems()
                )
        );
    }

    private void publishProductChangeMessage(
        Product product, UserProductAddToCartRequest request) {
        template.convertAndSend(
            "/topic/public",
            product.getName() + " " + product.getColor() + " "
                + "quantity decreased by " + request.getNumberOfItems()
        );
    }

    private Product validateAndReturnProduct(UserProductAddToCartRequest request) throws RequestException {
        isNotNull(request, INVALID_INPUT);
        isNotNull(request.getUserId(), MISSING_USER_ID);
        isNotNull(request.getProductId(), MISSING_PRODUCT_ID);
        isNotNull(request.getNumberOfItems(), MISSING_NUMBER_OF_ITEMS);
        Optional<Product> product = productService.find(request.getProductId());
        isTrue(product.isPresent(), PRODUCT_NOT_EXISTS);
        isTrue(request.getNumberOfItems() <= product.get().getNumberOfAvailableItems(),
            SHOULD_BE_LESS_THAN_AVAILABLE_PRODUCT);
        return product.get();
    }
}
