package com.iranlaravel.springboot.controller;

import com.iranlaravel.springboot.dao.ProductCategoryRepository;
import com.iranlaravel.springboot.dao.ProductRepository;
import com.iranlaravel.springboot.entity.Product;
import com.iranlaravel.springboot.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @GetMapping(value="/api/v1.1/pr")
    public List<Product> getProduct(){
        return productRepository.findAll();
    }


    @PostMapping("/api/v1.1/pr/new")
    Product newProduct(@RequestBody Product newProduct){
//        return newProduct;
        return productRepository.save(newProduct);
    }

    @PostMapping("/api/v1.1/cat/new")
    ProductCategory newCategory(@RequestBody ProductCategory newcat){
//        return newcat;
        return productCategoryRepository.save(newcat);
    }
}
