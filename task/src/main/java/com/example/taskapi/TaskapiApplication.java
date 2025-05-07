package com.example.taskapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TaskapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskapiApplication.class, args);
	}

}
