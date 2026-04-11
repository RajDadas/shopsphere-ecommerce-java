package com.shopsphere.service;

import com.shopsphere.entity.CartItem;
import com.shopsphere.entity.Product;
import com.shopsphere.repository.CartItemRepo;
import com.shopsphere.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartItemRepo cartRepo;
    private final ProductRepo productRepo;

    public CartService(CartItemRepo cartRepo, ProductRepo productRepo) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }

    public void addToCart(Long productId) {
        Product product = productRepo.findById(productId).orElseThrow();
        CartItem item = new CartItem();
        item.setProduct(product);
        item.setQuantity(1);
        cartRepo.save(item);
    }

    public List<CartItem> getCartItems() {
        return cartRepo.findAll();
    }
}
