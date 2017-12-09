/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teepiik.SpringNews.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author teepiik
 */
@Entity
public class Category extends AbstractPersistable<Long>{
    private String name;
    
    // mappedBy = "categories"
    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    private List<News> news = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
    
    public void addNews(News news) {
        this.news.add(news);
    }
}
