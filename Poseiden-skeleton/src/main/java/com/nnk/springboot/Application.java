package com.nnk.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"<com.nnk.springboot.service>"})
@EnableJpaRepositories(basePackages="<com.nnk.springboot.repositories>")
@EnableTransactionManagement
@EntityScan(basePackages="<com.nnk.springboot.domain>")

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
