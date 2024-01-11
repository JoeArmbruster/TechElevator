package com.techelevator.controller;

import com.techelevator.model.Cart;
import com.techelevator.service.CartService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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



}
