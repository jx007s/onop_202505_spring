package anno_p;

import java.util.Arrays;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentCarMain {

	public static void main(String[] args) {
		AbstractApplicationContext myContext = 
				new ClassPathXmlApplicationContext("qqww/componentCarAnno.xml");
		
		System.out.println(Arrays.toString(myContext.getBeanDefinitionNames()));
		
		
		System.out.println(myContext.getBean("f1"));
		System.out.println(myContext.getBean("truck"));
		
		
		
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




