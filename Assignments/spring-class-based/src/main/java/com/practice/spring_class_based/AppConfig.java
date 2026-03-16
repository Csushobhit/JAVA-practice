package com.practice.spring_class_based;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.practice" )
public class AppConfig {
	
	@Bean
	public Laptop laptop() {
		return new Laptop();
	}
	
	@Bean
	public Programmer programmer() {
		Programmer p = new Programmer();
		p.setLaptop(laptop());
		p.setName("Sumit");
		return p;
	}
}
