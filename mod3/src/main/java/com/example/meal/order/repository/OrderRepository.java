package com.example.meal.order.repository;

import com.example.meal.client.model.Client;
import com.example.meal.order.model.Order;

import java.util.List;

public class OrderRepository implements IOrderRepository {
    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public void delete(Order order) {

    }

    @Override
    public void delete(Integer order) {

    }

    @Override
    public Order getById(String id) {
        return null;
    }

    @Override
    public List<Order> getByClient(Client client) {
        return null;
    }
}
