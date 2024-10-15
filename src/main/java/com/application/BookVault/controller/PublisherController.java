package com.application.BookVault.controller;

import com.application.BookVault.entity.Publisher;
import com.application.BookVault.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublisherController {

    @Autowired
   private PublisherService publisherService;

    @GetMapping("/publishers")
    public String findAllPublishers(Model model){
        model.addAttribute("publishers", publisherService.findAllPublisher());
        return "publishers";
    }

    @GetMapping("/remove-publisher/{id}")
    public String removePublisher(@PathVariable Long id, Model model){
        publisherService.deletePublisher(id);
        return "redirect:/publishers";
    }

    @GetMapping("/update-publisher/{id}")
    public String updatePublisher(@PathVariable Long id, Model model){
        model.addAttribute(publisherService.findPublisherById(id));
        return "update-publisher";
    }

    @PostMapping("/update-publisher/{id}")
    public String saveUpdatePublisher(@PathVariable Long id, Model model, Publisher publisher, BindingResult result) {
        if(result.hasErrors()) {
            return "update-publisher";
        }
        publisherService.updatePublisher(publisher);

        model.addAttribute("publishers", publisherService.findAllPublisher());
        return "redirect:/publishers";

    }

    @GetMapping("/add-publisher")
    public String showCreatePublisher(Publisher publisher , Model model){
        model.addAttribute("publisher", publisher);         // this is optional
        return "add-publisher";
    }

    @PostMapping("/save-publisher")
    public String saveCreatedPublisher(Publisher publisher, Model model, BindingResult result){
        if(result.hasErrors()){
            return "add-publisher";
        }
        publisherService.createPublisher(publisher);
        model.addAttribute("publishers", publisherService.findAllPublisher());      // this is optional
        return "redirect:/publishers";
    }

}
