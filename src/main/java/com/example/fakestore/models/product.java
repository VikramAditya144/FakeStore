package com.example.fakestore.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class product {
    private long id;
    private String title;
    private String description;
    private double price;
    private category category;
    private String image;
}
