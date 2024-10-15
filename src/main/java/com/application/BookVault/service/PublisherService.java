package com.application.BookVault.service;

import com.application.BookVault.repository.PublisherRepository;
import com.application.BookVault.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;


    public List<Publisher> findAllPublisher(){
        return publisherRepository.findAll();
    }

    public Publisher findPublisherById(Long id){
        return publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found"));
    }

    public void createPublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void deletePublisher(Long id){
        publisherRepository.deleteById(id);
    }

    public void updatePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }



}
