package com.nec.jimba.sample.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private int age;
	private String name;
	
	public User() {
		
	}
	
	public User(int id, String name, int age) {
		this.id=id;
		this.age=age;
		this.name=name;
	}

	
}
