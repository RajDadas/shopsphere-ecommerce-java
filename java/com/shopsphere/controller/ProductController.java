
package com.shopsphere.controller;

import com.shopsphere.repo.ProductRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private final ProductRepo repo;

    public ProductController(ProductRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", repo.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String add(@RequestParam String name, @RequestParam double price) {
        var p = new com.shopsphere.entity.Product();
        p.setName(name);
        p.setPrice(price);
        repo.save(p);
        return "redirect:/";
    }
}
