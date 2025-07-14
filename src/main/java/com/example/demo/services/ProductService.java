package com.example.demo.services;

import java.util.List;

import com.example.demo.dtos.CreateProductRequestDto;
import com.example.demo.models.Product;

public interface ProductService {

    List<Product> getAllProducts();

    Product getSingleProduct(long id);

    Product createProduct(CreateProductRequestDto createProductRequestDto);
}