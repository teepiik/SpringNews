/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teepiik.SpringNews.controller;

import com.teepiik.SpringNews.domain.Item;
import com.teepiik.SpringNews.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author teepiik
 */
@RestController
public class ItemController {
    
    @Autowired
    ItemService itemService;
    
    @Autowired
    public void setup() {
        Item item1 = new Item();
        Item item2 = new Item();
        
        item1.setKing("uuno");
        item2.setKing("harald");
        
        itemService.addItem(item1);
        itemService.addItem(item2);
    }
    
}
