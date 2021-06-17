package com.dummy.dummydmanagement;

import com.dummy.dummydmanagement.service.ItemService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executors;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dummy.dummydmanagement", "com.jayway.blog"})
public class DummyManagementApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(DummyManagementApplication.class, args);
		context.getBean(ItemService.class).getAllItemsService();
	}

	@Bean
	public Scheduler jdbcScheduler() {
		return Schedulers.fromExecutor(Executors.newFixedThreadPool(100));
	}

}
