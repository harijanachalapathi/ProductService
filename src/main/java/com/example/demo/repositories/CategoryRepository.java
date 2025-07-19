package com.example.demo.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
Category findByTitle(String title);


Optional<Category> findById(int id);
    
    // Additional query methods can be defined here if needed
}
