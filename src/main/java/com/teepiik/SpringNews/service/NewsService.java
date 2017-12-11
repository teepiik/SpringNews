/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teepiik.SpringNews.service;

import com.teepiik.SpringNews.domain.Category;
import com.teepiik.SpringNews.domain.News;
import com.teepiik.SpringNews.domain.Reporter;
import com.teepiik.SpringNews.repository.CategoryRepository;
import com.teepiik.SpringNews.repository.NewsRepository;
import com.teepiik.SpringNews.repository.ReporterRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author teepiik
 */
@Service
public class NewsService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private ReporterRepository reporterRepository;
    
    @Autowired
    private NewsRepository newsRepository;
    
    public Long addNews(News news) {
        // add assign?
        return newsRepository.save(news).getId();
    }
    
    // handles news editing
    @Transactional
    public void EditOne(News news, Long oldId) {
        News editing = newsRepository.getOne(oldId);
        editing.setHeadline(news.getHeadline());
        editing.setLeadParagraph(news.getLeadParagraph());
        editing.setNewsContent(news.getNewsContent());
        // assign needed?
        editing.setCategories(news.getCategories());
        editing.setReporters(news.getReporters());
        
        newsRepository.save(editing);
    }
    
    @Transactional
    public void assignCategory(Long categoryId, Long newsId) {
        News news = newsRepository.getOne(newsId);
        Category category = categoryRepository.getOne(categoryId);
        news.addCategory(category);
        category.addNews(news);
        newsRepository.save(news);
        categoryRepository.save(category);
    }
    
    @Transactional
    public void assignReporter(Long reporterId, Long newsId) {
        News news = newsRepository.getOne(newsId);
        Reporter reporter = reporterRepository.getOne(reporterId);
        news.addReporter(reporter);
        reporter.addNews(news);
        newsRepository.save(news);
        reporterRepository.save(reporter);
    }
    
    public void deleteNews(long newsId) {
        this.newsRepository.delete(newsId);
    }
    
    // lists all news connected with given category
    public List<News> findWithCategory(Category category) {
        List<News> newsByCategory = new ArrayList<>();
        List<News> allNews = new ArrayList<>();
        allNews = newsRepository.findAll();
        for(News news : allNews) {
            if(news.getCategories().contains(category)) {
                newsByCategory.add(news);
            }             
        }      
        return newsByCategory;
    }
    
    
}
