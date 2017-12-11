/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teepiik.SpringNews.domain;

import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author teepiik
 */
public class NewsTest {
    
    public NewsTest() {
    }
    
    private News news;
    private Category category;
    private Reporter reporter;
    
    
    @Before
    public void setUp() throws Exception {
        news = new News();
        category = new Category();
        category.setName("Sports");
        reporter = new Reporter();
        reporter.setName("Alex");
        
        
    }

    @Test
    public void getSetHeadline() {
        news.setHeadline("lorem ipsum");
        assertEquals(news.getHeadline(), "lorem ipsum");

    }
    
    @Test
    public void getSetLeadParagraph() {
        news.setLeadParagraph("lorem ipsum");
        assertEquals(news.getLeadParagraph(), "lorem ipsum");
    }
    
    @Test
    public void getSetNewsContent() {
        news.setNewsContent("lorem ipsum");
        assertEquals(news.getNewsContent(), "lorem ipsum");
    }
    
    @Test
    public void getAddCategories() {
        news.addCategory(category);
        assertEquals(news.getCategories().get(0), category);
    }
    
    @Test
    public void getAddReporter() {
        news.addReporter(reporter);
        assertEquals(news.getReporters().get(0), reporter);
    }
    
    @Test
    public void getSetDate() {
        LocalDateTime date = LocalDateTime.now();
        news.setDate(date);
        assertEquals(date, news.getDate());
    }
}
