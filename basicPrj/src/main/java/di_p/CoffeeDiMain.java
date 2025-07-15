package di_p;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoffeeDiMain {

	public static void main(String[] args) {
		// 커피숍을 구현하세요
	 ///원두 : 원산지, 맛
	 /// 커피 : 원두, 이름, 가격
	// 커피 3개 이상
		AbstractApplicationContext coffeeCon = 
				new ClassPathXmlApplicationContext("qqww/coffeeDi.xml");
		
		
		for (String cName : "cc1,cc2,cc3".split(",")) {
			System.out.println(coffeeCon.getBean(cName));
		}
		
		
		coffeeCon.close();

	}

}
