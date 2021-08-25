package com.example.meal.order.repository;

import com.example.meal.client.model.Client;
import com.example.meal.order.model.Order;

import java.util.List;

public interface IOrderRepository {
    Order save(Order order);

    Order update(Order order);

    void delete(Order order);
    void delete(Integer order);

    Order getById(String id);

    List<Order> getByClient(Client client);
}
