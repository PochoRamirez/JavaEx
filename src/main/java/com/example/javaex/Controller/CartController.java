package com.example.javaex.Controller;

import com.example.javaex.Utils.Constants;
import com.example.javaex.model.Cart;
import com.example.javaex.model.Item;
import com.example.javaex.service.ShoppingCartSvc;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CartController {

    @Autowired
    ShoppingCartSvc shoppingCartSvc;

    @ApiOperation(value = "Create a new Cart", response = Long.class , tags = {Constants.CART_METHODS})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successful operation", response = Long.class),
            @ApiResponse(code = 500, message = "Internal Server Error, Failed creating the car",
                    response = Void.class)})
    @RequestMapping(value = "carts", method = RequestMethod.POST)
    public ResponseEntity<Cart> createCart() {
        return ResponseEntity.ok(shoppingCartSvc.createCart());
    }

    @ApiOperation(value = "Add an item to a specific cart.", response = Cart.class, tags = {Constants.CART_METHODS})
    @RequestMapping(value = "carts/{cartId}/item", method = RequestMethod.POST)
    public ResponseEntity<Cart> addItemToCart(@PathVariable("cartId") Long cartId, @RequestBody Item item) {
        shoppingCartSvc.addItemToCart(item,cartId);
        return ResponseEntity.status(Response.SC_OK).build();
    }


    @ApiOperation(value = "Remove a specific item from a specific cart.", response = Cart.class, tags = {Constants.CART_METHODS})
    @RequestMapping(value = "carts/{cartId}/item", method = RequestMethod.DELETE)
    public ResponseEntity<Cart> removeItemInCart(@PathVariable("cartId") Long cartId, @RequestBody Item item) {
        shoppingCartSvc.removeItemInCart(cartId, item);
        return ResponseEntity.status(Response.SC_OK).build();
    }

    @ApiOperation(value = "Clear a specific cart (remove all items).", response = Cart.class, tags = {Constants.CART_METHODS})
    @RequestMapping(value = "carts/{cartId}", method = RequestMethod.DELETE)
    public ResponseEntity<Cart> removeAllItemsInCart(@PathVariable("cartId") Long cartId) {
        shoppingCartSvc.removeAllItemsInCart(cartId);
        return ResponseEntity.status(Response.SC_OK).build();
    }

    @ApiOperation(value = "List items of a specific cart.", response = Cart.class, tags = {Constants.CART_METHODS})
    @RequestMapping(value = "carts/{cartId}/item", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getAllItemsInCart(@PathVariable("cartId") Long cartId) {
        shoppingCartSvc.getAllItemsInCart(cartId);
        return ResponseEntity.status(Response.SC_OK).build();
    }

    @ApiOperation(value = "Get the total amount to be paid.", response = Integer.class, tags = {Constants.CART_METHODS})
    @RequestMapping(value = "carts/{cartId}/amount", method = RequestMethod.GET)
    public ResponseEntity<Double> getTotalAmount(@PathVariable("cartId") Long cartId) {
        shoppingCartSvc.getTotalAmount(cartId);
        return ResponseEntity.status(Response.SC_OK).build();
    }

}
