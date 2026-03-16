package com.practice.spring_xml_demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");
    	
    	Programmer p = context.getBean("programmer", Programmer.class);
    	p.code();
    }
}
