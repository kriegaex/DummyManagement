package com.dummy.dummydmanagement;

import com.jayway.blog.YourAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executors;

@SpringBootApplication
public class DummyManagementApplication {

	@YourAnnotation(isRun = true)
	public static void main(String[] args) {
		SpringApplication.run(DummyManagementApplication.class, args);
	}

	@Bean
	public Scheduler jdbcScheduler() {
		return Schedulers.fromExecutor(Executors.newFixedThreadPool(100));
	}

}
