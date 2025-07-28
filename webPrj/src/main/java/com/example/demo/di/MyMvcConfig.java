package com.example.demo.di;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import jakarta.annotation.Resource;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer{


	
	@Resource
	EventInterceptor eventIc;
	
	@Resource
	PathShopInterCeptor psIc;


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		System.out.println("addInterceptors 실행");
		
		//registry.addInterceptor(eventIc);  모든 페이지에 적용
		
		registry.addInterceptor(eventIc).addPathPatterns("/intercep/event");
		
		registry.addInterceptor(psIc)
		.addPathPatterns("/pathShop/**", "/thyme/**")
		.addPathPatterns("/shop/**")		//검사대상
		.excludePathPatterns("/pathShop/info/**"); //검사 예외
	}

}
