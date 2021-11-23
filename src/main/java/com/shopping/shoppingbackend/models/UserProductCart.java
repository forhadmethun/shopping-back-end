package com.shopping.shoppingbackend.models;

import javax.persistence.*;

@Entity
@Table(name = "user_product_cart")
public class UserProductCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long userId;
	private Long productId;
	private Integer numberOfItems;

	public UserProductCart() {

	}

	public Long getId() {
		return id;
	}

	public UserProductCart setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public UserProductCart setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public Long getProductId() {
		return productId;
	}

	public UserProductCart setProductId(Long productId) {
		this.productId = productId;
		return this;
	}

	public Integer getNumberOfItems() {
		return numberOfItems;
	}

	public UserProductCart setNumberOfItems(Integer numberOfItems) {
		this.numberOfItems = numberOfItems;
		return this;
	}
}
