package com.shopping.shoppingbackend.payload.response;

import java.math.BigDecimal;

public class ProductResponse {
	private Long id;
	private String name;
	private String description;
	private String color;
	private Integer rank;
	private BigDecimal price;
	private Integer numberOfAvailableItems;

	public Long getId() {
		return id;
	}

	public ProductResponse setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public ProductResponse setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public ProductResponse setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getColor() {
		return color;
	}

	public ProductResponse setColor(String color) {
		this.color = color;
		return this;
	}

	public Integer getRank() {
		return rank;
	}

	public ProductResponse setRank(Integer rank) {
		this.rank = rank;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public ProductResponse setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public Integer getNumberOfAvailableItems() {
		return numberOfAvailableItems;
	}

	public ProductResponse setNumberOfAvailableItems(Integer numberOfAvailableItems) {
		this.numberOfAvailableItems = numberOfAvailableItems;
		return this;
	}
}
