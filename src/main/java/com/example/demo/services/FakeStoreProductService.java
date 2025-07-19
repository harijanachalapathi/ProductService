package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dtos.FakeStoreProductDtos;
import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryRepository;



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
        FakeStoreProductDtos[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDtos[].class);
                                       
        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDtos fakeStoreProductDto : fakeStoreProductDtos) {
            Product p = fakeStoreProductDto.toProduct();
        }

        return products;
    }

    @Override
    public Product getSingleProduct(long id) {
        // Implementation to fetch a single product by id

        ResponseEntity<FakeStoreProductDtos> fakeStoreProductDtosResponseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id, 
        FakeStoreProductDtos.class);

        return fakeStoreProductDtosResponseEntity.getBody().toProduct();
    }

    @Override
    public Product createProduct(String title, 
                          String description, 
                          double price, 
                          String imageUrl,
                          String category) {
        // Implementation to create a new product
        FakeStoreProductDtos fakeStoreProductDtos = new FakeStoreProductDtos();
        fakeStoreProductDtos.setTitle(title);
        fakeStoreProductDtos.setDescription(description);
        fakeStoreProductDtos.setPrice(price);
        fakeStoreProductDtos.setImage(imageUrl);
        fakeStoreProductDtos.setCategory(category);

        return restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProductDtos, FakeStoreProductDtos.class).toProduct();
    }

}
