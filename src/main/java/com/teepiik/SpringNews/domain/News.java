/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teepiik.SpringNews.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.TemporalType;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.Temporal;

/**
 *
 * @author teepiik
 */
@Entity
public class News extends AbstractPersistable<Long>{
    private String headline;    
    private String leadPraragraph;
    private String newsContent;
    
    // ei ehkä toimi vielä
    private Date date;
    @ManyToOne
    private Reporter reporter;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories = new ArrayList<>();
    // pic

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getLeadPraragraph() {
        return leadPraragraph;
    }

    public void setLeadPraragraph(String leadPraragraph) {
        this.leadPraragraph = leadPraragraph;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Reporter getReporter() {
        return reporter;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }


    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
