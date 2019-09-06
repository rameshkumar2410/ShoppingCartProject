package com.shoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDetails{
	
	private String productName;
	private int quantity;
	private double price;	

}
