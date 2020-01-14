package com.nec.jimba.sample.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
	private int id;
	
	private String name;
	
	private int age;

}
