package anno_p;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import anno_p.bean_p.BeanInit;

public class ConfigMain {

	public static void main(String[] args) {
		ApplicationContext myContext = 
				new AnnotationConfigApplicationContext(BeanInit.class);
		
		System.out.println(Arrays.toString(myContext.getBeanDefinitionNames()));
		
		System.out.println(myContext.getBean("cam1"));
		System.out.println(myContext.getBean("ph1"));
		System.out.println(myContext.getBean("sp2"));
		System.out.println(myContext.getBean("ph3"));
		System.out.println(myContext.getBean("cams"));
		System.out.println(myContext.getBean("cams2"));
		
	}

}
