package com.example.meal.client.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Client {
    private Integer id;

    private String name;

    private String given;

    private List<Address> addresses;
}
