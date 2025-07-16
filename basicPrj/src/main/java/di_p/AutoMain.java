package di_p;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoMain {

	public static void main(String[] args) {
		//bean 생성이 완료되 있음
		AbstractApplicationContext myContext = 
				new ClassPathXmlApplicationContext("qqww/autoDi.xml", "qqww/autoDi_two.xml");
		
		System.out.println(myContext.getBean("hp1"));
		System.out.println(myContext.getBean("hp2"));
		System.out.println(myContext.getBean("hp3"));
		System.out.println(myContext.getBean("hp4"));
		System.out.println(myContext.getBean("cp1"));
		System.out.println(myContext.getBean("cp2"));
		System.out.println(myContext.getBean("tb"));
		
		System.out.println(myContext.getBean("bung"));
		myContext.close();
	}
	
}

/*

데스크탑   - 본체 1, 모니터 2, 키보드 1, 마우스 1
노트북    - 본체 1, 마우스 1

 * */
