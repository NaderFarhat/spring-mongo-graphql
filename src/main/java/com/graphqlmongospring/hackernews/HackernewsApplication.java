package com.graphqlmongospring.hackernews;

import com.graphqlmongospring.hackernews.model.Link;
import com.graphqlmongospring.hackernews.repository.LinkRepository;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class HackernewsApplication {

	@Autowired
	private LinkRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(HackernewsApplication.class, args);
	}

	@Bean
	public SmartInitializingSingleton importProcessor() {
		return () -> {
			System.out.println("A");
//			repository.deleteAll();
//
//			repository.save(new Link("google.com", "Google website"));
//			repository.save(new Link("microsoft.com", "Microsoft website"));
//
//			// fetch all customers
//			System.out.println("Customers found with findAll():");
//			System.out.println("-------------------------------");
//			for (Link link : repository.findAll()) {
//				System.out.println(link);
//			}
		};

	}
}
