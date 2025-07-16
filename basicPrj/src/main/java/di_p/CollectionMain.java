package di_p;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionMain {

	public static void main(String[] args) {
		//bean 생성이 완료되 있음
		AbstractApplicationContext myContext = 
				new ClassPathXmlApplicationContext("qqww/collectionDi.xml");
		
		System.out.println(myContext.getBean("arr1"));
		System.out.println(myContext.getBean("ss1"));
		System.out.println(myContext.getBean("st1"));
		
		
		ArrayList pp1 = new ArrayList();
		pp1.add("아기상어");
		pp1.add("엄마상어");
		pp1.add("아빠상어");
		pp1.add("할머니상어");
		pp1.add("할아버지상어");
		pp1.add("아기상어");
		
		ArrayList arr2 = new ArrayList(pp1);
		HashSet ss2 = new HashSet(pp1); 
		
		System.out.println("arr2 : "+arr2);
		System.out.println("ss2 : "+ss2);
		
		System.out.println(myContext.getBean("arr3"));
		System.out.println(myContext.getBean("ss3"));
		
		System.out.println(myContext.getBean("mm1"));
		
		System.out.println(myContext.getBean("arr4"));
		System.out.println(myContext.getBean("st2"));
		myContext.close();
	}
	/* 
		자동차를 조립하세요
		
		자동차 요소
		핸들과 바퀴는 다른회사에서 가져옴
		이름, 핸들, 바퀴4개
		
	 * */

}
