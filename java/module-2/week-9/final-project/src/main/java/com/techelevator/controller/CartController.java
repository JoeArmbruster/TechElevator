package com.techelevator.controller;

import com.techelevator.model.Cart;
import com.techelevator.model.CartItem;
import com.techelevator.service.CartService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/cart")
@PreAuthorize("isAuthenticated()")
public class CartController {

    private final CartService cartService;

    public CartController (CartService cartService){
        this.cartService = cartService;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public Cart getCart(Principal principal){
        Cart userCart = cartService.getUserCart(principal);

        return  userCart;
    }

    @RequestMapping(path = "/items", method = RequestMethod.POST)
    public void addCartItem(@RequestBody CartItem cartItem, Principal principal){
        cartService.addCartItem(cartItem, principal);
    }

    @RequestMapping(path = "/items/{itemId", method = RequestMethod.DELETE)
    public void removeCartItem(@PathVariable int itemId, Principal principal){
        cartService.removeCartItem(itemId, principal);
    }

    @RequestMapping(path = "", method = RequestMethod.DELETE)
    public void clearCart(Principal principal){
        cartService.clearCart(principal);
    }

}
