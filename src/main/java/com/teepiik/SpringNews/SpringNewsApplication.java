package com.teepiik.SpringNews;

import com.teepiik.SpringNews.domain.Category;
import com.teepiik.SpringNews.domain.News;
import com.teepiik.SpringNews.service.CategoryService;
import com.teepiik.SpringNews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringNewsApplication {
    
        @Autowired
        private CategoryService categoryService;
        
        @Autowired
        private NewsService newsService;
        
        
	public static void main(String[] args) {
		SpringApplication.run(SpringNewsApplication.class, args);
	}
        
        // Lisätään alkudataa
        @Bean
        public boolean init() {
            
            News news1 = new News();
            news1.setHeadline("Test headline");
            news1.setLeadParagraph("Test lead paragraph");
            newsService.addNews(news1);
            
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
            
            newsService.assignCategory(category.getId(), news1.getId());
            
            /* THIS NEEDS FIXING
            newsService.assignCategory(category3.getId(), news1.getId());
            */


            return true;
        }
}
