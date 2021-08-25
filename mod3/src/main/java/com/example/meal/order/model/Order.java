package com.example.meal.order.model;

import com.example.meal.client.model.Client;
import com.example.meal.product.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Order {
    private Integer id;

    private Client client;

    private Date date;

    private Double sum;

    private EnumOrderStatus status;

    private List<Product> products;
}
