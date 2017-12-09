/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teepiik.SpringNews.controller;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.teepiik.SpringNews.domain.News;
import com.teepiik.SpringNews.repository.CategoryRepository;
import com.teepiik.SpringNews.repository.NewsRepository;
import com.teepiik.SpringNews.repository.ReporterRepository;
import com.teepiik.SpringNews.service.NewsService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private ReporterRepository reporterRepository;

    @Autowired
    private NewsService newsService;

    //
    @GetMapping("/")
    public String index(Model model) {
        //Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "date");
        //model.addAttribute("latest", this.newsRepository.findAll(pageable));

        model.addAttribute("latest", newsRepository.findTop5ByOrderByDateDesc());
        return "index";
    }

    @GetMapping("/news/{id}")
    public String viewOneNews(Model model, @PathVariable Long id) {
        News news = newsRepository.getOne(id);
        int view = news.getViews() + 1;
        news.setViews(view);
        newsRepository.save(news);
        model.addAttribute("news", news);
        model.addAttribute("categories", news.getCategories());
        model.addAttribute("reporters", news.getReporters());
        return "newsShowOne";
    }
    
    @GetMapping("/news/edit/{id}")
    public String editOneNews(Model model, @PathVariable Long id) {
        //News news = newsRepository.getOne(id);
        // stub news
        model.addAttribute("news", new News());

        model.addAttribute("newsOld", newsRepository.getOne(id));
        model.addAttribute("allCategories", categoryRepository.findAll());
        model.addAttribute("allReporters", reporterRepository.findAll());
        return "newsEdit";
    }
    
    @PostMapping("/news/edit/{id}")
    public String handleEdit(@Valid News news, BindingResult bs, Model model, @PathVariable Long id) {
        if (bs.hasErrors()) {
            model.addAttribute("news", new News());
            model.addAttribute("newsOld", newsRepository.getOne(id));
            model.addAttribute("allCategories", categoryRepository.findAll());
            model.addAttribute("allReporters", reporterRepository.findAll());
            return "newsEdit";
        } else {

            // Handle edit method
            newsService.EditOne(news, id);
            return "redirect:/news";
        }

    }

    @PostMapping("/news/{id}/delete")
    public String deleteNews(@PathVariable Long id) {

        newsService.deleteNews(id);

        return "redirect:/news";
    }

    @GetMapping("/news")
    public String news(Model model) {
        model.addAttribute("newsList", newsRepository.findAll());
        return "newsListing";
    }

    @GetMapping("/createnews")
    public String createNews(Model model) {
        model.addAttribute("news", new News());
        model.addAttribute("allCategories", categoryRepository.findAll());
        model.addAttribute("allReporters", reporterRepository.findAll());
        return "newsCreate";
    }

    @PostMapping("/createnews")
    public String handleCreation(@Valid News news, BindingResult bs, Model model) {
        if (bs.hasErrors()) {
            model.addAttribute("news", new News());
            model.addAttribute("allCategories", categoryRepository.findAll());
            model.addAttribute("allReporters", reporterRepository.findAll());
            return "newsCreate";
        } else {
            // sets current time to date, aka news creation time

            news.setViews(0);
            newsRepository.save(news);
            return "redirect:/news";
        }

    }

}
