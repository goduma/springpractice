package com.nec.jimba.demo.domain;

import org.springframework.stereotype.Component;
@Component
public class User {
	int id;
	int age;
	String name;
	
	public User() {
		
	}
	
	public User(int id, String name, int age) {
		this.id=id;
		this.age=age;
		this.name=name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

}
