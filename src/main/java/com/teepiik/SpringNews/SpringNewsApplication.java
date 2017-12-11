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
        
        // Base data added here
        @Bean
        public boolean init() {
            
            News news1 = new News();
            news1.setHeadline("Patrik Laine in a point streak");
            news1.setLeadParagraph("Finnish forward has points in 5 consecutive games so far.");
            news1.setNewsContent("Last night Jets visited Penguins in a 5-4 overtime win. Laine had one powerplay goal in a second period when he one-timered Ehlers cross ice pass behind Matt Murray.");
            newsService.addNews(news1);
            
            News news2 = new News();
            news2.setHeadline("Is Lorem ipsum art?");
            news2.setLeadParagraph("Read the first lines of Lorem Ipsum here.");
            news2.setNewsContent(" Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque in mattis sem. In fermentum elit vel luctus egestas. Ut eros velit, faucibus quis tempus ut, sodales vitae neque. Praesent ac odio et leo sodales fermentum sed eu justo. Maecenas suscipit diam sed nisl auctor pharetra. Cras ac mi sem. Pellentesque neque nulla, suscipit eu neque eleifend, rhoncus iaculis eros. ");
            newsService.addNews(news2);
            
            Category category = new Category();
            Category category2 = new Category();
            Category category3 = new Category();
            Category category4 = new Category();
            Category category5 = new Category();
            Category category6 = new Category();
            Category category7 = new Category();
            Category category8 = new Category();
            
            category.setName("Finland");
            category2.setName("World");
            category3.setName("Sports");
            category4.setName("Health");
            category5.setName("Science");
            category6.setName("Style & Arts");
            category7.setName("Business");
            category8.setName("Politics");
            
            categoryService.addCategory(category);
            categoryService.addCategory(category2);
            categoryService.addCategory(category3);
            categoryService.addCategory(category4);
            categoryService.addCategory(category5);
            categoryService.addCategory(category6);
            categoryService.addCategory(category7);
            categoryService.addCategory(category8);
            
           
            Reporter repo1 = new Reporter();
            Reporter repo2 = new Reporter();
            Reporter repo3 = new Reporter();
            Reporter repo4 = new Reporter();
            repo1.setName("Judith Blackwater");
            repo2.setName("Michael Monroe");
            repo3.setName("Marie Curry");
            repo4.setName("Steven Kingston");
            reporterService.addReporter(repo1);
            reporterService.addReporter(repo2);
            reporterService.addReporter(repo3);
            reporterService.addReporter(repo4);
            
            newsService.assignCategory(category.getId(), news1.getId());         
            newsService.assignCategory(category3.getId(), news1.getId());            
            newsService.assignCategory(category6.getId(), news2.getId());
            
            newsService.assignReporter(repo1.getId(), news1.getId());
            newsService.assignReporter(repo1.getId(), news2.getId());
            newsService.assignReporter(repo2.getId(), news1.getId());
            
            return true;
        }
}
