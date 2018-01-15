package com.wadewilson.guru.spring5webapp.controller;

import com.wadewilson.guru.spring5webapp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors",authorRepository.findAll());
        return "authors";
    }

}
