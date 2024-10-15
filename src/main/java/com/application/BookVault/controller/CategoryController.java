package com.application.BookVault.controller;

import com.application.BookVault.entity.Category;
import com.application.BookVault.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
   private CategoryService categoryService;

    @GetMapping("/categories")
    public String findAllCategories(Model model){
        List<Category> category = categoryService.findAllCategory();
        model.addAttribute("categories", category);
        return "category";
    }

    @GetMapping("/remove-category/{id}")
    public String removeCategory(@PathVariable Long id, Model model){
        categoryService.deleteCategory(id);
        model.addAttribute("categories", categoryService.findAllCategory());
        return "category";
    }

    @GetMapping("/update-category/{id}")
    public String updateCategory(@PathVariable Long id, Model model){
        model.addAttribute("category", categoryService.findCategory(id));
        return "updatecategory";
    }

    @PostMapping("/update-category/{id}")
    public String saveCategory(@PathVariable Long id, Category category, Model model , BindingResult result){
        if(result.hasErrors()){
            return "updatecategory";
        }
        categoryService.updateCategory(category);
        model.addAttribute("categories", categoryService.findAllCategory());
         return "redirect:/categories";

    }

    @GetMapping("/add-category")
    public String showCreateCategory(Category category){
        return "add-category";
    }

    @PostMapping("/save-category")
    public String saveCategory(Category category,BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-category";
        }
        categoryService.createCategory(category);
        model.addAttribute("categories", categoryService.findAllCategory());
        return "redirect:/categories";
    }

}