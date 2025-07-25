package aop_p.main_p;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.webToon.JoSuk;

public class AopMain {

	public static void main(String[] args) {
		AbstractApplicationContext myContext = 
				new ClassPathXmlApplicationContext("qqww/webToonAop.xml");

		JoSuk js = myContext.getBean("joSuk", JoSuk.class);
		Object rr = js.dog1(10, "아기상어");
		System.out.println("rr : "+rr);
		
		rr = js.dog2(20, "엄마상어");
		System.out.println("rr : "+rr);
		
		rr = js.wife(30);
		System.out.println("rr : "+rr);
		
		rr = js.papa(40);
		System.out.println("rr : "+rr);
		
		myContext.close();
	}

}
