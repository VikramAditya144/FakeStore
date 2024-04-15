package com.example.fakestore.services;

import com.example.fakestore.dtos.FakeStoreProductDto;
import com.example.fakestore.models.product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements productService{
    @Override
    public product getProductbyID(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id , FakeStoreProductDto.class);
        return convertToProduct(fakeStoreProductDto);
    }

    public List<product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);

        List<product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertToProduct(fakeStoreProductDto));
        }
        return products;
    }
    public product convertToProduct(FakeStoreProductDto fakeStoreProductDto) {
        product pro = new product();
        pro.setId(fakeStoreProductDto.getId());
        pro.setTitle(fakeStoreProductDto.getTitle());
        pro.setPrice(fakeStoreProductDto.getPrice());
        pro.setDescription(fakeStoreProductDto.getDescription());
        return pro;
    }
}
