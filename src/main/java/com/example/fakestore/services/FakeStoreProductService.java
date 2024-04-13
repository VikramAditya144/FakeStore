package com.example.fakestore.services;

import com.example.fakestore.dtos.FakeStoreProductDto;
import com.example.fakestore.models.product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class FakeStoreProductService implements productService{
    @Override
    public product getProductbyID(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id , FakeStoreProductDto.class);
        product pro = new product();
        pro.setId(fakeStoreProductDto.getId());
        pro.setTitle(fakeStoreProductDto.getTitle());
        pro.setPrice(fakeStoreProductDto.getPrice());
        pro.setDescription(fakeStoreProductDto.getDescription());
        return pro;
    }
}
