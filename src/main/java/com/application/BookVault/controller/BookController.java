package com.application.BookVault.controller;


import com.application.BookVault.entity.Book;
import com.application.BookVault.service.AuthorService;
import com.application.BookVault.service.BookService;
import com.application.BookVault.service.CategoryService;
import com.application.BookVault.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
     public String findAllBooks(Model model){
         List<Book> allBooks = bookService.findAllBooks();
         model.addAttribute("books", allBooks);
         return "book";
     }

    @GetMapping("/book/{id}")
     public String findBook(@PathVariable Long id, Model model){
        Book book = bookService.findBookbyId(id);
        model.addAttribute("book", book);
        return "listofbooks";
     }

     @GetMapping("/remove-book/{id}")
    public String removeBook(@PathVariable Long id,Model model){
        bookService.deleteBook(id);
        model.addAttribute("books",bookService.findAllBooks());
        return "book";
    }

    @GetMapping("/update-book/{id}")
    public String updateBook(@PathVariable Long id, Model model){
        Book book  = bookService.findBookbyId(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.findAllCategory());
        model.addAttribute("publishers", publisherService.findAllPublisher());
        model.addAttribute("authors", authorService.findAllAuthor());
        return "updatebook";
    }

    @PostMapping("/save-update/{id}")
    //bindingResult is used to check for any validation error in UI(perticularly in forms)
    public String saveUpdate(@PathVariable Long id,Book book, BindingResult result, Model model){

        if(result.hasErrors()){
            return "updatebook";
        }
        bookService.updateBook(book);
        model.addAttribute("book" , bookService.findAllBooks());

        return "redirect:/books";
    }


    @GetMapping("/add-book")
    public String addBook(Book book, Model model){
        model.addAttribute("categories", categoryService.findAllCategory());
        model.addAttribute("publishers", publisherService.findAllPublisher());
        model.addAttribute("authors", authorService.findAllAuthor());
        return "add-book";
    }

    @PostMapping("/save-book")
    //bindingResult is used to check for any validation error in UI(perticularly in forms)
    public String savebook(Book book, BindingResult result, Model model){

        if(result.hasErrors()){
            return "add-book";
        }
        bookService.createBook(book);
        model.addAttribute("book" , bookService.findAllBooks());

        return "redirect:/books";
    }
}
