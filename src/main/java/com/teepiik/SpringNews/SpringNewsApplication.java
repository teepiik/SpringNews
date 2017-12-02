package com.teepiik.SpringNews;

import com.teepiik.SpringNews.domain.Item;
import com.teepiik.SpringNews.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringNewsApplication {
    
        @Autowired
        private ItemService itemService;
        
        
	public static void main(String[] args) {
		SpringApplication.run(SpringNewsApplication.class, args);
	}
        /*
        @Bean
        public boolean init() {
            Item item1 = new Item();
            Item item2 = new Item();
        
            item1.setKing("uuno");
            item2.setKing("harald");
        
            itemService.addItem(item1);
            itemService.addItem(item2);
            return true;
        }*/
}
