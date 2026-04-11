package com.shopsphere.controller;

import com.shopsphere.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("items", service.getCartItems());
        return "cart";
    }

    @PostMapping("/cart/add/{id}")
    public String addToCart(@PathVariable Long id) {
        service.addToCart(id);
        return "redirect:/";
    }
}
