package anno_p;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredMain {

	public static void main(String[] args) {
		AbstractApplicationContext myContext = 
				new ClassPathXmlApplicationContext("qqww/autoAnno.xml");
		
		System.out.println(myContext.getBean("hp1"));
		
		System.out.println(myContext.getBean("car"));

		myContext.close();
	}

}

/*

데스크탑   - 본체 1, 모니터 2, 키보드 1, 마우스 1
노트북    - 본체 1, 마우스 1

*/



