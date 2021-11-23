package com.shopping.shoppingbackend.process.product;

import com.shopping.shoppingbackend.db.services.ProductService;
import com.shopping.shoppingbackend.db.services.UserProductCartService;
import com.shopping.shoppingbackend.exception.RequestException;
import com.shopping.shoppingbackend.models.Product;
import com.shopping.shoppingbackend.models.UserProductCart;
import com.shopping.shoppingbackend.payload.request.UserProductRemoveFromCartRequest;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.shopping.shoppingbackend.util.RequestConstant.*;
import static com.shopping.shoppingbackend.util.ValidateUtil.isNotNull;
import static com.shopping.shoppingbackend.util.ValidateUtil.isTrue;

@Component
@Transactional
public class RemoveProductFromCart {
    private final ProductService productService;
    private final SimpMessagingTemplate template;
    private final UserProductCartService userProductCartService;

    public RemoveProductFromCart(
        ProductService productService,
        SimpMessagingTemplate template,
        UserProductCartService userProductCartService) {
        this.productService = productService;
        this.template = template;
        this.userProductCartService = userProductCartService;
    }

    public void remove(UserProductRemoveFromCartRequest request) throws RequestException {
        Product product = validateAndReturnProduct(request);
        Optional<UserProductCart> userProductCart = userProductCartService
            .findByUserIdAndProductId(request.getUserId(), request.getProductId());
        isTrue(userProductCart.isPresent(), PRODUCT_NOT_EXISTS_IN_CART);
        isTrue(request.getNumberOfItems() <= userProductCart.get().getNumberOfItems(),
            SHOULD_BE_LESS_THAN_AVAILABLE_PRODUCT);
        userProductCart.ifPresent(productCart -> {
            updateAvailableProduct(product, request);
            removeProductFromCart(productCart, request);
        });
        publishProductChangeMessage(product, request);
    }

    private void publishProductChangeMessage(
        Product product, UserProductRemoveFromCartRequest request) {
        template.convertAndSend(
            "/topic/public",
            product.getName() + " " + product.getColor() + " "
                + "quantity increased by " + request.getNumberOfItems()
            );
    }

    private void updateAvailableProduct(
        Product product, UserProductRemoveFromCartRequest request) {
        product.setNumberOfAvailableItems(
            product.getNumberOfAvailableItems() + request.getNumberOfItems()
        );
        productService.save(product);
    }

    private void removeProductFromCart(UserProductCart userProductCart, UserProductRemoveFromCartRequest request) {
        int numberOfItems = userProductCart.getNumberOfItems() - request.getNumberOfItems();
        if(numberOfItems == 0) {
            userProductCartService.delete(userProductCart.getId());
        }
        else {
            userProductCartService.save(userProductCart.setNumberOfItems(numberOfItems));
        }
    }

    private Product validateAndReturnProduct(
        UserProductRemoveFromCartRequest request) throws RequestException {
        isNotNull(request, INVALID_INPUT);
        isNotNull(request.getUserId(), MISSING_USER_ID);
        isNotNull(request.getProductId(), MISSING_PRODUCT_ID);
        Optional<Product> product = productService.find(request.getProductId());
        isTrue(product.isPresent(), PRODUCT_NOT_EXISTS);
        return product.get();
    }
}
