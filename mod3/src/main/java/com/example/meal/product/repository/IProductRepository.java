package com.example.meal.product.repository;

import com.example.meal.product.model.Product;

import java.util.List;

public interface IProductRepository {
    Product save(Product product);

    Product update(Product product);

    void delete(Product product);

    void delete(String id);

    Product getById(String id);

    List<Product> getByCategory(String category);
}
