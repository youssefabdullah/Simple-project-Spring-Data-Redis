package com.example.springdataredisex.controller;

import com.example.springdataredisex.entity.Product;
import com.example.springdataredisex.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductDao productDao;

    @GetMapping
    public List<Product> productList(){
        return productDao.productList();
    }
    @PostMapping
    public Product save(@RequestBody Product product){
        return productDao.save(product);
    }
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id){
        return productDao.deleteProductById(id);
    }
    @GetMapping("/{id}")
    public Product findById(@PathVariable int id){
        return productDao.findProductById(id);
    }
}
