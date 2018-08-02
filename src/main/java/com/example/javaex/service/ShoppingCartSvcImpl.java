package com.example.javaex.service;

import com.example.javaex.DAO.CartDAO;
import com.example.javaex.model.Cart;
import com.example.javaex.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ShoppingCartSvcImpl implements ShoppingCartSvc {

    @Autowired
    private CartDAO cartDao;


    @Override
    public Cart addItemToCart(Item item, Long cartId) {
        Cart cart = cartDao.findById(cartId).orElseThrow(NotFoundException::new);
        if (cart.getItems() == null) {
            Set<Item> items = new HashSet<>();
            items.add(item);
        }
        cart.getItems().add(item);
        return cart;
    }

    @Override
    public Cart createCart() {
        return cartDao.save(new Cart());
    }

    @Override
    public Cart removeItemInCart(Long cartId,Item item) {
        return null;
    }

    @Override
    public Cart removeAllItemsInCart(Long cartId) {
        return null;
    }

    @Override
    public List<Item> getAllItemsInCart(Long cartId) {
        return null;
    }

    @Override
    public Double getTotalAmount(Long cartId) {
        Cart cart = cartDao.findById(cartId).orElseThrow(NotFoundException::new);
        return cart.getTotal();
    }
}
