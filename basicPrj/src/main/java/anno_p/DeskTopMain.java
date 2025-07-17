package anno_p;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeskTopMain {

	public static void main(String[] args) {
		AbstractApplicationContext myContext = 
				new ClassPathXmlApplicationContext("qqww/deskTopAnno.xml");
		
		System.out.println(myContext.getBean("nb"));
		System.out.println(myContext.getBean("dt"));

		myContext.close();
	}

}

/*

데스크탑   - 본체 1, 모니터 2, 키보드 1, 마우스 1
노트북    - 본체 1, 마우스 1

*/



