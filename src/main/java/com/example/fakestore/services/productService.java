package com.example.fakestore.services;

import com.example.fakestore.models.product;

import java.util.List;

public interface productService {
    product getProductbyID(Long id);

    List<product> getAllProducts();
}