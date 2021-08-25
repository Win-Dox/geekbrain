package com.example.meal.product.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Integer id;

    private String name;

    private String description;

    private Double sum;

    private EnumCategory category;
}
