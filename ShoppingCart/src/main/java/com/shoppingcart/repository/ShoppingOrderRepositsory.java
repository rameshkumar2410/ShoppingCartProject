package com.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.model.ShoppingCart;

@Repository
public interface ShoppingOrderRepositsory extends JpaRepository<ShoppingCart, Long>{

}
