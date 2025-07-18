package aop_p.webToon;

import org.springframework.stereotype.Component;

@Component
public class JoSuk {

	public String dog1(int aa, String bb) {
		
		System.out.println("JoSuk.dog1 실행 : "+aa+","+bb);
		return "센세이션";
	}
}
