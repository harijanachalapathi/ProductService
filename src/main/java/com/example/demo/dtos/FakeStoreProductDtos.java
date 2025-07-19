package com.example.demo.dtos;

import com.example.demo.models.Category;
import com.example.demo.models.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDtos {
//private int id;  it's not an entity class hence removing id
private String title;
private String description;
private String image;
private String category;    
private double price;


public Product toProduct(){
    Product product = new Product();
    product.setTitle(title);
    product.setPrice(price);
    product.setDescription(description);
    

    Category category1 = new Category();
    category1.setTitle(category);


   product.setAbcCategory(category1);
   product.setImageurl(image);

    return product;
}
}
