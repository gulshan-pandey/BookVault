package com.application.BookVault.controller;

import com.application.BookVault.entity.Author;
import com.application.BookVault.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/authors")
    private String findAllAuthors(Model model){
        model.addAttribute("authors", authorService.findAllAuthor());
        return "authors";
    }

    @GetMapping("/remove-author/{id}")
    public String removeAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
        return "redirect:/authors";
    }

    @GetMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable Long id, Model model){
        model.addAttribute("author", authorService.findById(id));
        return "update-author";
    }

    @PostMapping("/update-author/{id}")
    public String saveUpdatedAuthor(@PathVariable Long id, Author author, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "update-author";
        }else{
            model.addAttribute("authors", authorService.findAllAuthor());
            authorService.updateAuthor(author);
            return "redirect:/authors";
        }
    }


    @GetMapping("/add-author")
    public String showCreateAuthor(Author author){
        return "add-new-author";
    }

    @PostMapping("/save-author")
    public String saveAndShowAuthor(Author author, Model model , BindingResult result)
    {
        if(result.hasErrors()) {
            return "add-new-author";
        } else {
            authorService.createAuthor(author);
            model.addAttribute("authors", authorService.findAllAuthor());           // optional
            return "redirect:/authors";

        }
    }

}
