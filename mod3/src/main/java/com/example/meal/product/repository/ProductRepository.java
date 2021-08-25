package com.example.meal.product.repository;

import com.example.meal.product.model.Product;

import java.util.List;

public class ProductRepository implements IProductRepository {
    @Override
    public Product save(Product product) {
        return product;
    }

    @Override
    public Product update(Product product) {
        return product;
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Product getById(String id) {
        return null;
    }

    @Override
    public List<Product> getByCategory(String category) {
        return null;
    }
}
