package com.example.meal.client.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private Integer id;

    private String street;

    private String house;

    private String apartment;

    private String comments;

    private Boolean isMain;
}
