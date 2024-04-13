package com.example.fakestore.Controller;

import com.example.fakestore.dtos.FakeStoreProductDto;
import com.example.fakestore.models.product;
import com.example.fakestore.services.FakeStoreProductService;
import com.example.fakestore.services.productService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private productService ProductService;

    ProductController(productService ProductService) {
        this.ProductService = ProductService;
    }
    @GetMapping("/{id}")
    public product getProductById(@PathVariable("id") Long id) {
        return ProductService.getProductbyID(id);
    }
}
