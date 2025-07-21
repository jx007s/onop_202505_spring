package com.example.demo.model;

import java.util.List;

import lombok.Data;


public class BuyOrder {

	List<Product> prods;
	Address ad;
	
	public int getTot() {
		int res = 0;
		
		for (Product product : prods) {
			res += product.getTot();
		}
		
		return res;
	}

	public List<Product> getProds() {
		return prods;
	}

	public void setProds(List<Product> prods) {
		this.prods = prods;
	}

	public Address getAd() {
		return ad;
	}

	public void setAd(Address ad) {
		this.ad = ad;
	}
	
	
}
