package com.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Product Detail Entity
 * @author Ramesh
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ProductDetail")
public class ProductDetail {

	@Id
	@Column(name = "ID", nullable = false, length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;

	@Column(name = "productName")
	private String productName;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private double price;

	public ProductDetail() {
		
	}
	
	
	public ProductDetail(long productId, String productName, int quantity, double price) {
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}



	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
