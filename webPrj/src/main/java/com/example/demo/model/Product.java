package com.example.demo.model;

import lombok.Data;

@Data
public class Product {

	String pname;
	int price, cnt;
	
	public int getTot() {
		return price * cnt;
	}
}
