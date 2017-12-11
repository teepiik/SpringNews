/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teepiik.SpringNews.controller;

import com.teepiik.SpringNews.domain.Category;
import com.teepiik.SpringNews.repository.CategoryRepository;
import com.teepiik.SpringNews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author teepiik
 */
@Controller
public class CategoryController {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private NewsService newsService;
    
    @GetMapping("/categories")
    public String categories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        
        return "categoryListing";
    }
    
    @GetMapping("/categories/{id}")
    public String newsByCategory(Model model, @PathVariable Long id) {
        Category category = categoryRepository.getOne(id);     
        model.addAttribute("category", category);
        model.addAttribute("newsOfCategory", newsService.findWithCategory(category));
            
        return "newsOfCategory";
    }
    
    
}
