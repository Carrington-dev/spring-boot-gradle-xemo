package com.example.xemo.shop.repository;

import com.example.xemo.shop.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    public List<Product> findByCategoryId(Integer id);
}
