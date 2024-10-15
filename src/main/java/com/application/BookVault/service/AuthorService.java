package com.application.BookVault.service;

import com.application.BookVault.repository.AuthorRepository;
import com.application.BookVault.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public List<Author> findAllAuthor(){
        return authorRepository.findAll();
    }

    public Author findById(Long id){
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public void createAuthor(Author author){
        authorRepository.save(author);
    }

    public  void deleteAuthor(Long id){
        authorRepository.deleteById(id);
    }

    public void updateAuthor(Author author){
        authorRepository.save(author);
    }


}


