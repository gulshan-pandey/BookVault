package com.application.BookVault.controller;

import com.application.BookVault.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
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

}
