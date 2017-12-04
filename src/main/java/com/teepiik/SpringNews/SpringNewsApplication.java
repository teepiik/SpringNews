package com.teepiik.SpringNews;

import com.teepiik.SpringNews.domain.Category;
import com.teepiik.SpringNews.domain.News;
import com.teepiik.SpringNews.service.CategoryService;
import com.teepiik.SpringNews.service.NewsService;
import java.util.Date;
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
            news1.setNewsContent("Testing news, this is content");
            Date time = new Date();
            news1.setDate(time); // have to add manually in setup
            newsService.addNews(news1);
            
            News news2 = new News();
            news2.setHeadline("Test DELETE");
            news2.setLeadParagraph("Destroy me");
            news2.setNewsContent("This news is for delete testing");
            Date time2 = new Date();
            news2.setDate(time2); // have to add manually in setup
            newsService.addNews(news2);
            
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
            newsService.assignCategory(category3.getId(), news1.getId());
            
            newsService.assignCategory(category3.getId(), news2.getId());
            


            return true;
        }
}
