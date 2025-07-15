package di_p;

import java.util.Arrays;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiMain {

	public static void main(String[] args) {
		
		System.out.println("DiMain 입니다.");
		
		Camera cam1 = new Camera();
		cam1.setKind("미러리스");
		cam1.setName("캐논500D");
		System.out.println("cam1 : "+cam1);
		
		HandPhone hp1 = new HandPhone();
		hp1.name = "아이폰";
		hp1.price = 200;
		hp1.cam = cam1;
		System.out.println("hp1 : "+hp1);
		
		
		
		//bean 생성이 완료되 있음
		AbstractApplicationContext myContext = 
				new ClassPathXmlApplicationContext("qqww/myDi.xml");
		
		//bean 가져오기
		HandPhone hp2 = (HandPhone)myContext.getBean("pp1");
		
		System.out.println("hp2 : "+hp2);
		
		
		HandPhone hp3 = myContext.getBean("pp3", HandPhone.class);
		
		System.out.println("hp3 : "+hp3);
		
		Object hp4 = myContext.getBean("pp4");
		
		System.out.println("hp4 : "+hp4);
		
		String [] names = myContext.getBeanDefinitionNames();
		
		System.out.println(Arrays.toString(names));
		
		myContext.close();
		
		
		// 커피숍을 구현하세요
		 
		 ///원두 : 원산지, 맛
		 
		 /// 커피 : 원두, 이름, 가격
		
		// 커피 3개 이상
	}

}
