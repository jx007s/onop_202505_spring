package com.example.demo.model;

import lombok.Data;

@Data
public class Stud {

	String pname;
	int kor, eng, mat, tot, avg;
	
	public void calc() {
		tot = kor + eng + mat;
		avg = tot / 3;
	}
	
}
