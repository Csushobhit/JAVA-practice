package com.practice.spring_class_based;

public class Programmer {
	private Laptop laptop;
	private String name;
	
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void code() {
		System.out.println(name + " is Coding using Laptop");
		laptop.compile();
	}
}
