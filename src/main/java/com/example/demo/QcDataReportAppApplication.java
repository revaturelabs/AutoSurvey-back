package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ComponentScan("com.revature")
@EnableJpaRepositories("com.revature.repos")
@EntityScan("com.revature.beans")
@EnableSwagger2
public class QcDataReportAppApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(QcDataReportAppApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(QcDataReportAppApplication.class);
	}

}

