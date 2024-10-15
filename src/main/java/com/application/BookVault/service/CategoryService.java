package com.application.BookVault.service;

import com.application.BookVault.repository.CategoryRepository;
import com.application.BookVault.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;          // from Repository


    public List<Category> findAllCategory(){
        return categoryRepository.findAll();
    }

    public Category findCategory(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

    public void updateCategory(Category category){
        categoryRepository.save(category);
    }




}
