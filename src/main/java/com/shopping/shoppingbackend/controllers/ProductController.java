package com.shopping.shoppingbackend.controllers;

import com.shopping.shoppingbackend.exception.RequestException;
import com.shopping.shoppingbackend.payload.request.ProductRequest;
import com.shopping.shoppingbackend.payload.request.UserProductAddToCartRequest;
import com.shopping.shoppingbackend.payload.request.UserProductRemoveFromCartRequest;
import com.shopping.shoppingbackend.payload.response.ProductResponse;
import com.shopping.shoppingbackend.payload.response.UserProductCartResponse;
import com.shopping.shoppingbackend.process.product.*;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/products")
public class ProductController {
	private final AddProductToCart addProductToCart;
	private final CreateProduct createProduct;
	private final ProductQueries productQueries;
	private final RemoveProductFromCart removeProductFromCart;
	private final UserProductCartQueries userProductCartQueries;

	public ProductController(
		AddProductToCart addProductToCart,
		CreateProduct createProduct,
		ProductQueries productQueries,
		RemoveProductFromCart removeProductFromCart,
		UserProductCartQueries userProductCartQueries) {
		this.createProduct = createProduct;
		this.productQueries = productQueries;
		this.addProductToCart = addProductToCart;
		this.removeProductFromCart = removeProductFromCart;
		this.userProductCartQueries = userProductCartQueries;
	}

	@GetMapping("/all")
	public ResponseEntity<List<ProductResponse>> allProducts() {
		return ResponseEntity.ok(productQueries.findAll());
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ProductResponse> createProduct(
		@RequestBody ProductRequest productRequest) {
		return ResponseEntity.ok(createProduct.create(productRequest));
	}

	@PostMapping("/cart/add")
	public ResponseEntity<List<ProductResponse>> addProductToCart(
		@RequestBody UserProductAddToCartRequest userProductAddToCartRequest
		) throws RequestException {
		addProductToCart.add(userProductAddToCartRequest);
		return ResponseEntity.ok(productQueries.findAll());
	}

	@PostMapping("/cart/remove")
	public ResponseEntity<List<ProductResponse>> removeProductFromCart(
		@RequestBody UserProductRemoveFromCartRequest request
		) throws RequestException {
		removeProductFromCart.remove(request);
		return ResponseEntity.ok(productQueries.findAll());
	}

	@GetMapping("/user/{userId}/cart")
	public ResponseEntity<List<UserProductCartResponse>> getUserProductCartItems(
		@PathVariable("userId") Long userId
	) {
		return ResponseEntity.ok(userProductCartQueries.findByUserId(userId));
	}

	@MessageMapping("/sendProductChange")
	@SendTo("/topic/public")
	public String sendProductChangeMessage(@Payload String message) {
		return message;
	}

}
