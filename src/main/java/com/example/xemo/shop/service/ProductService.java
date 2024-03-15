package com.example.xemo.shop.service;

import com.example.xemo.shop.models.Product;
import com.example.xemo.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product) {
        Product newProduct = productRepository.save(product);
        return newProduct;
    }

    public Product updateProduct(Product product) {
        Product newProduct = productRepository.save(product);
        return newProduct;
    }

    public List<Product> allProducts() {
        List<Product> products = new ArrayList<>();
        Iterable<Product> productIterable = productRepository.findAll();
        productIterable.forEach(products::add);
        return products;
    }

    public List<Product> getProductsByCategoryId(Integer id) {
        List<Product> products = new ArrayList<>();
        Iterable<Product> productIterable = productRepository.findByCategoryId(id);
        productIterable.forEach(products::add);
        return products;
    }
}
