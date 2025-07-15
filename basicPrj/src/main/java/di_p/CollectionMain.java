package di_p;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionMain {

	public static void main(String[] args) {
		//bean 생성이 완료되 있음
		AbstractApplicationContext myContext = 
				new ClassPathXmlApplicationContext("qqww/collectionDi.xml");
		
		System.out.println(myContext.getBean("arr1"));

		myContext.close();
	}

}
