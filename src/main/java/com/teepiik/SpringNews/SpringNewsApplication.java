package com.teepiik.SpringNews;

import com.teepiik.SpringNews.domain.Category;
import com.teepiik.SpringNews.domain.Item;
import com.teepiik.SpringNews.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringNewsApplication {
    
        @Autowired
        private CategoryService categoryService;
        
        
	public static void main(String[] args) {
		SpringApplication.run(SpringNewsApplication.class, args);
	}
        
        // Lisätään alkudataa
        @Bean
        public boolean init() {
            
            Category category = new Category();
            Category category2 = new Category();
            Category category3 = new Category();
            Category category4 = new Category();
            
            category.setName("Kotimaan uutiset");
            category2.setName("Ulkomaan uutiset");
            category3.setName("Urheilu");
            category4.setName("Viihde");
            
            categoryService.addCategory(category);
            categoryService.addCategory(category2);
            categoryService.addCategory(category3);
            categoryService.addCategory(category4);

            return true;
        }
}
