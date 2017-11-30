/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teepiik.SpringNews.service;

import com.teepiik.SpringNews.domain.Item;
import com.teepiik.SpringNews.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author teepiik
 */
@Service
public class ItemService {
    
    @Autowired
    ItemRepository itemRepository;

    public Long addItem(Item item) {
        return itemRepository.save(item).getId();
    }
    
}
