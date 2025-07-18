package aop_p.main_p;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.webToon.JoSuk;

public class PointcutMain {

	public static void main(String[] args) {
		AbstractApplicationContext myContext = 
				new ClassPathXmlApplicationContext("qqww/pointcutAop.xml");

		JoSuk js = myContext.getBean("joSuk", JoSuk.class);
		Object rr = js.dog1(10, "아기상어");
		System.out.println("rr : "+rr);
		
		rr = js.dog2(20, "엄마상어");
		System.out.println("rr : "+rr);
		
		rr = js.wife(30);
		System.out.println("rr : "+rr);
		
		rr = js.wife(0);
		System.out.println("rr : "+rr);
		
		myContext.close();
	}

}

/*

도형 클래스를 구현하세요 
PI = Math.PI
r = 반지름

calc(선분들을 받음)         
선분 갯수에 따른 리턴
1 - 원
2 - 직사각형
3 - 직각삼각형

aop를 이용하여 각 도형들의 누계를 출력하세요
누계 정보 : 갯수, 넓이, 둘레
*/







