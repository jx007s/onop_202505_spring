package aaa.model;

import lombok.Data;

@Data
public class PageInfo {

	String msg, goUrl, mainUrl, service;
	int nowPage=1;
	
	
	public void setService(String service) {
		this.service = service;
		mainUrl = service;
	}
}
