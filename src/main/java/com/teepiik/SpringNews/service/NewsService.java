/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teepiik.SpringNews.service;

import com.teepiik.SpringNews.domain.News;
import com.teepiik.SpringNews.repository.CategoryRepository;
import com.teepiik.SpringNews.repository.NewsRepository;
import com.teepiik.SpringNews.repository.ReporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return newsRepository.save(news).getId();
    }
    
    public void assignCategory(Long categoryId, Long newsId) {
        
    }
    
    public void assignReporter(Long reporterId, Long newsId) {
        
    }
    
}
