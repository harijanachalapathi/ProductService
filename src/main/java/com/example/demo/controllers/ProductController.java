package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.CreateProductRequestDto;
import com.example.demo.models.Product; // Add this import if Product is in models package
import com.example.demo.services.ProductService; // Add this import, adjust the package if needed

@RestController
public class ProductController {

    public ProductService productService;

    // public ProductController(ProductService productService) {
    //     this.productService = productService;
    // }

   @GetMapping("/products")  
   public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")    
    public Product getSingleProduct(@PathVariable("id") long id) {
        return productService.getSingleProduct(id);
    }

    //create a product
    @PostMapping("/products")
    private Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return productService.createProduct(createProductRequestDto);
    }
    
}
