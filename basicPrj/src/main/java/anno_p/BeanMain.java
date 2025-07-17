package anno_p;

import java.util.Arrays;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanMain {

	public static void main(String[] args) {
		AbstractApplicationContext myContext = 
				new ClassPathXmlApplicationContext("qqww/beanAnno.xml");
		
		System.out.println(Arrays.toString(myContext.getBeanDefinitionNames()));
		
		System.out.println(myContext.getBean("cam1"));
		System.out.println(myContext.getBean("ph1"));
		System.out.println(myContext.getBean("sp2"));
		System.out.println(myContext.getBean("ph3"));
		System.out.println(myContext.getBean("cams"));
		System.out.println(myContext.getBean("cams2"));
		
		myContext.close();
	}

}
/*
/////////////
자동차를 출력하세요


////  자동차 종류 - 클래스
         F1 --- 이름, 바퀴(4), 부스터
         트럭 ---이름, 바퀴(4), 짐칸
 * */




