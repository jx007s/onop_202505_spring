package anno_p;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredMain {

	public static void main(String[] args) {
		AbstractApplicationContext myContext = 
				new ClassPathXmlApplicationContext("qqww/autoAnno.xml");
		
		System.out.println(myContext.getBean("hp1"));

		myContext.close();
	}

}
