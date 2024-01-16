package com.example.springdataredisex.repository;

import com.example.springdataredisex.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    public static final String HASH_KEY = "Product";
    @Autowired
    @Qualifier("stringObjectRedisTemplate")
    private RedisTemplate template;

    public Product save(Product product) {
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> productList() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(int id) {
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteProductById(int id) {
        template.opsForHash().delete(HASH_KEY, id);
        return "Product remove";
    }
}
