package com.shopping.shoppingbackend.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20)
	private String name;

	@NotBlank
	private String description;

	@NotBlank
	@Size(max = 20)
	private String color;

	private Integer rank;
	private BigDecimal price;
	private Integer numberOfAvailableItems;

	public Product() {

	}

	public Long getId() {
		return id;
	}

	public Product setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Product setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Product setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getColor() {
		return color;
	}

	public Product setColor(String color) {
		this.color = color;
		return this;
	}

	public Integer getRank() {
		return rank;
	}

	public Product setRank(Integer rank) {
		this.rank = rank;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Product setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public Integer getNumberOfAvailableItems() {
		return numberOfAvailableItems;
	}

	public Product setNumberOfAvailableItems(Integer numberOfAvailableItems) {
		this.numberOfAvailableItems = numberOfAvailableItems;
		return this;
	}
}
