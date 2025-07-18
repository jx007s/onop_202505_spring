package aop_p.main_p;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.shape.Circle;
import aop_p.shape.Rectangle;
import aop_p.shape.Triangle;


public class ShapeMain {

	public static void main(String[] args) {
		AbstractApplicationContext myContext = 
				new ClassPathXmlApplicationContext("qqww/shapeAop.xml");

		System.out.println(myContext.getBean("rectangle", Rectangle.class).calc(5,7));
		System.out.println(myContext.getBean("circle", Circle.class).calc(8));
		System.out.println(myContext.getBean("triangle", Triangle.class).calc(5,6,8));
		
		
		System.out.println(myContext.getBean("shapeData"));
		
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
누계 정보 : 갯수, 넓이
*/







