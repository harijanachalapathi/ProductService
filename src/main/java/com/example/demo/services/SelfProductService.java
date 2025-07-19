package com.example.demo.services;

import com.example.demo.models.Product;
import com.example.demo.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.CategoryRepository;

import com.example.demo.services.ProductService; // Adjust the import based on your package structure
// Adjust the import based on your package structure
@Service
public class SelfProductService {

    
    @Autowired
    private CategoryRepository categoryRepository;

    public Product createProoduct(String title,
                                  String description,
                                  double price,
                                  String imageUrl,
                                  String category){

        Product p = new Product();
        p.setTitle(title);
        p.setDescription(description);
        p.setPrice(price);
        p.setImageurl(imageUrl);
        
    Category categoryFromDB =  categoryRepository.findByTitle(category);
        if(categoryFromDB == null){
        Category newcategory = new Category();
        newcategory.setTitle(category);
        categoryFromDB = newcategory;
        }
        p.setCategory(categoryFromDB);
        return p;

    }
}
