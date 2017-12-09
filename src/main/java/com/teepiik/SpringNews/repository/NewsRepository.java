/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teepiik.SpringNews.repository;

import com.teepiik.SpringNews.domain.News;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author teepiik
 */
public interface NewsRepository extends JpaRepository<News, Long>{
    //List<News> findByDate(Pageable pageable);
}
