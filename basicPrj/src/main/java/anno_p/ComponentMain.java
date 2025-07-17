package anno_p;

import java.util.Arrays;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentMain {

	public static void main(String[] args) {
		AbstractApplicationContext myContext = 
				new ClassPathXmlApplicationContext("qqww/componentAnno.xml");
		
		System.out.println(Arrays.toString(myContext.getBeanDefinitionNames()));
		
		//System.out.println(myContext.getBean("cylinder"));
		System.out.println(myContext.getBean("cycy"));
		//System.out.println(myContext.getBean("Engine"));
		System.out.println(myContext.getBean("engine"));  //component 설정시 클래스이름 소문자 시작이 bean 이름
		System.out.println(myContext.getBean("wing"));
		
		System.out.println(myContext.getBean("cessna"));
		
		myContext.close();
	}

}



