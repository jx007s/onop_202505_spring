package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
	
	

	public Person(String name, int height, boolean marriage) {

		this.name = name;
		this.height = height;
		this.marriage = marriage;
	}
	String name;
	int height,age;
	boolean marriage;
}
