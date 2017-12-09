package com.teepiik.SpringNews;

import com.teepiik.SpringNews.domain.Category;
import com.teepiik.SpringNews.domain.News;
import com.teepiik.SpringNews.domain.Reporter;
import com.teepiik.SpringNews.service.CategoryService;
import com.teepiik.SpringNews.service.NewsService;
import com.teepiik.SpringNews.service.ReporterService;
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
        
        @Autowired
        private ReporterService reporterService;
        
        
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
            newsService.addNews(news1);
            
            News news2 = new News();
            news2.setHeadline("Test DELETE");
            news2.setLeadParagraph("Destroy me");
            news2.setNewsContent("This news is for delete testing");
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
            
           
            Reporter repo1 = new Reporter();
            Reporter repo2 = new Reporter();
            repo1.setName("Pekka");
            repo2.setName("Kikka");
            reporterService.addReporter(repo1);
            reporterService.addReporter(repo2);
            
            newsService.assignCategory(category.getId(), news1.getId());         
            newsService.assignCategory(category3.getId(), news1.getId());            
            newsService.assignCategory(category3.getId(), news2.getId());
            
            newsService.assignReporter(repo1.getId(), news1.getId());
            newsService.assignReporter(repo1.getId(), news2.getId());
            newsService.assignReporter(repo2.getId(), news1.getId());
            
            return true;
        }
}
