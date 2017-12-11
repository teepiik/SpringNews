/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teepiik.SpringNews.service;

import com.teepiik.SpringNews.domain.Category;
import com.teepiik.SpringNews.domain.News;
import com.teepiik.SpringNews.domain.Reporter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author teepiik
 */
public class NewsServiceTest {

    private News news;
    private Category category;
    private Reporter reporter;

    public NewsServiceTest() {
        
    }

    @Before
    public void setUp() {
        news = new News();
        news.setHeadline("lorem ipsum");
        category = new Category();
        category.setName("Sports");
        reporter = new Reporter();
        reporter.setName("Alex");
    }

    // @Test
    // public void hello() {}
}
