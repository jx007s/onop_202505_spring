package com.example.demo.model;

import org.springframework.web.multipart.MultipartFile;

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
	String name, pid, pw;
	int height,age;
	boolean marriage;
	MultipartFile upfile;
}
