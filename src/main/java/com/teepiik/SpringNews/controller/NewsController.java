/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teepiik.SpringNews.controller;

import com.teepiik.SpringNews.domain.News;
import com.teepiik.SpringNews.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author teepiik
 */
@Controller
public class NewsController {
    
    @Autowired
    private NewsRepository newsRepository;
    
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
    
    @GetMapping("/news/{id}")
    public String viewOneNews(Model model, @PathVariable Long id) {
        News news = newsRepository.getOne(id);
        model.addAttribute("news", news);
        model.addAttribute("categories", news.getCategories());
        return "newsShowOne";
    }
    
    @GetMapping("/news")
    public String news(Model model) {
        model.addAttribute("newsList", newsRepository.findAll());
        return "newsListing";
    }
    
    @GetMapping("/createnews")
    public String createNews(Model model) {
        //model.addAttribute("newsList", newsRepository.findAll());
        return "newsCreate";
    }
    
    @PostMapping("/createnews")
    public String handleCreation(Model model) {
        return "redirect:/news";
    }
}
