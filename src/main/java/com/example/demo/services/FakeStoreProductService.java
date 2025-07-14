package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dtos.CreateProductRequestDto;
import com.example.demo.dtos.FakeStoreProductDtos;
import com.example.demo.models.Product;

// import com.example.demo.controllers.dtos.FakeStoreProductDto;

// If FakeStoreProductDto exists in another package, update the import accordingly, for example:
// import com.example.demo.dtos.FakeStoreProductDto;

// Or, if the class does not exist, create it in the appropriate package (e.g., com.example.demo.dtos).



@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate; // using this we will be able to call the fake store api 
    
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }   

    @Override
    public List<Product> getAllProducts() {
        // Implementation to fetch all products
        return null;
    }

    @Override
    public Product getSingleProduct(long id) {
        // Implementation to fetch a single product by id

        FakeStoreProductDtos fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, 
        FakeStoreProductDtos.class);

        return fakeStoreProductDtos.toProduct();
    }

    @Override
    public Product createProduct(CreateProductRequestDto createProductRequestDto) {
        // Implementation to create a new product
        return null;
    }

}
