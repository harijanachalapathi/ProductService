package com.example.demo.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
public class Category extends BaseModel{
    
    @Id
    private String title;
    
    @OneToMany(mappedBy="abcCategory", cascade = {CascadeType.REMOVE})
    List<Product> product;

}
