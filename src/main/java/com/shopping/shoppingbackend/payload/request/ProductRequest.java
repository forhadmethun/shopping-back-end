package com.shopping.shoppingbackend.payload.request;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class ProductRequest {
	@NotBlank
	private String name;

	@NotBlank
	private String description;

	@NotBlank
	private String color;

	@NotBlank
	private Integer rank;

	@NotBlank
	private BigDecimal price;

	@NotBlank
	private Integer numberOfAvailableItems;

	public String getName() {
		return name;
	}

	public ProductRequest setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public ProductRequest setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getColor() {
		return color;
	}

	public ProductRequest setColor(String color) {
		this.color = color;
		return this;
	}

	public Integer getRank() {
		return rank;
	}

	public ProductRequest setRank(Integer rank) {
		this.rank = rank;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public ProductRequest setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public Integer getNumberOfAvailableItems() {
		return numberOfAvailableItems;
	}

	public ProductRequest setNumberOfAvailableItems(Integer numberOfAvailableItems) {
		this.numberOfAvailableItems = numberOfAvailableItems;
		return this;
	}
}
