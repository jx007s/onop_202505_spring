package di_p;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarMain {

	public static void main(String[] args) {
		//bean 생성이 완료되 있음
		AbstractApplicationContext myContext = 
				new ClassPathXmlApplicationContext("qqww/carDi.xml");
		
		System.out.println(myContext.getBean("cc1"));
		
		myContext.close();
	}
	/* 
		자동차를 조립하세요
		
		자동차 요소
		핸들과 바퀴는 다른회사에서 가져옴
		이름, 핸들, 바퀴4개
		
	 * */

}
