package com.example.xemo.shop.controllers;

import com.example.xemo.shop.models.Product;
import com.example.xemo.shop.service.ProductService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {
    private static final Gson gson = new Gson();

    @Autowired
    ProductService productService = new ProductService();

    @GetMapping("/")
    public String getHome() {
        return "<h1>Welcome To Xero Stores</h1>";
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.allProducts();
    }

    @PostMapping("/products")
    public @ResponseBody ResponseEntity<String> addProduct(@RequestBody Product product) {
        Product newProduct = productService.createProduct(product);
        String gsonResponse = gson.toJson(newProduct);
        return new ResponseEntity<>(gsonResponse,
                HttpStatus.OK);
    }

    @PostMapping("/products/{id}")
    public @ResponseBody ResponseEntity<String> updateProduct(@RequestBody Product product) {
        Product newProduct = productService.updateProduct(product);
        return new ResponseEntity<>("{ \"message\":\"Product created successfully\"}",
                HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public List<Product> getProductByCategory(@RequestParam Integer id){
        return productService.getProductsByCategoryId(id);
    }


}
