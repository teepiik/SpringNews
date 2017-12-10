/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teepiik.SpringNews.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author teepiik
 */
@Entity
public class News extends AbstractPersistable<Long>{
    
    @NotNull
    @Size(min=2, max=30)
    private String headline;
    @NotNull
    @Size(min=5, max=100)
    private String leadParagraph;
    @NotNull
    @Size(min=10, max=500)
    private String newsContent;
    
    private LocalDateTime date;
    
    /*
    @ManyToOne
    private Reporter reporter;*/
    
    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name = "news_reporters", joinColumns = @JoinColumn(name = "news_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "reporter_id", referencedColumnName = "id"))
    private List<Reporter> reporters = new ArrayList<>();
    
    // cascade = {CascadeType.PERSIST, CascadeType.MERGE} not working 
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "news_categories", joinColumns = @JoinColumn(name = "news_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private List<Category> categories = new ArrayList<>();
    
    private int views;
    
    public News() {
        this.date = LocalDateTime.now();
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getHeadline() {
        return headline;
    }

    public String getLeadParagraph() {
        return leadParagraph;
    }

    public void setLeadParagraph(String leadParagraph) {
        this.leadParagraph = leadParagraph;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    
    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public List<Reporter> getReporters() {
        return reporters;
    }

    public void setReporters(List<Reporter> reporters) {
        this.reporters = reporters;
    }
    
    public void addReporter(Reporter reporter) {
        this.reporters.add(reporter);
    }
}
