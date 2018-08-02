package com.example.javaex.service;

import com.example.javaex.model.Cart;
import com.example.javaex.model.Item;

import java.util.List;

public interface ShoppingCartSvc {

    Cart addItemToCart(Item item, Long cartId);

    Cart createCart();

    Cart removeItemInCart(Long cartId,Item item);

    Cart removeAllItemsInCart(Long cartId);

    List<Item> getAllItemsInCart(Long cartId);

    Double getTotalAmount(Long cartId);
}
