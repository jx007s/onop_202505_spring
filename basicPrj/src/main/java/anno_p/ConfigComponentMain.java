package anno_p;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



import anno_p.bean_p.ConfigCompScan;

public class ConfigComponentMain {

	public static void main(String[] args) {
		ApplicationContext myContext = 
				new AnnotationConfigApplicationContext(ConfigCompScan.class);
		
		System.out.println(Arrays.toString(myContext.getBeanDefinitionNames()));
		
		//System.out.println(myContext.getBean("cylinder"));
		System.out.println(myContext.getBean("cycy"));
		//System.out.println(myContext.getBean("Engine"));
		System.out.println(myContext.getBean("engine"));  //component 설정시 클래스이름 소문자 시작이 bean 이름
		System.out.println(myContext.getBean("wing"));
		
		System.out.println(myContext.getBean("cessna"));
		System.out.println(myContext.getBean("helicopter"));
		

	}

}
/*
/////////////
자동차를 출력하세요


////  자동차 종류 - 클래스
         F1 --- 이름, 바퀴(4), 부스터
         트럭 ---이름, 바퀴(4), 짐칸
 * */




