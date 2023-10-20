package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Items")
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="itemId")
	private long itemId;
	
	@NotBlank(message = "shortDescription can not be empty")
	@Size(max = 20,message = "shortDescription name can't be more than 20 characters")
	@Size(min=5, message="shortDescription must not be less than 5 characters")
	@Column(name="shortDescription")
	private String shortDescription;
	
	@NotNull(message = "price can not be null")
	@Column(name="price")
	private Double price;
	
	@NotBlank(message = "brand can not be null")
	@Column(name="brand")
	private String brand;
	
	public Items()
	{
		
	}

	public Items(long itemId, String shortDescription,Double price, String brand) {
		super();
		this.itemId = itemId;
		this.shortDescription = shortDescription;
		this.price = price;
		this.brand = brand;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", shortDescription=" + shortDescription + ", price=" + price + ", brand="
				+ brand + "]";
	}
	
	
	
}
