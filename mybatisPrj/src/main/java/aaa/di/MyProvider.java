package aaa.di;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
public class MyProvider implements ApplicationContextAware{
	
	@Getter
	ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("MyProvider.setApplicationContext 실행");
		
		//context를 멤버변수로 가져오기
		context = applicationContext;
	}

}
