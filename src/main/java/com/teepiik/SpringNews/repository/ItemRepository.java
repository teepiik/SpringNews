/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teepiik.SpringNews.repository;

import com.teepiik.SpringNews.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author teepiik
 */
public interface ItemRepository extends JpaRepository<Item, Long>{
    
}
