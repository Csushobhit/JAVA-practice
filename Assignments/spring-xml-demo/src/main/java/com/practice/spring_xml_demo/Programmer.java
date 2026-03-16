package com.practice.spring_xml_demo;

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
		System.out.println(name+" is Coding.");
		laptop.compile();
	}
}
