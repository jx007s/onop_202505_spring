package aop_p.webToon;

import org.springframework.stereotype.Component;

@Component
public class JoSuk {

	public String dog1(int aa, String bb) {
		
		System.out.println("JoSuk.dog1 실행 : "+aa+","+bb);
		return "센세이션";
	}
	
	public int dog2(int aa, String bb) {
		
		System.out.println("JoSuk.dog2 실행 : "+aa+","+bb);
		return 1234;
	}
	
	public String wife(int aa) {
		
		System.out.println("JoSuk.wife 실행 : "+aa);
		
		int bb = 1234/aa;
		
		return "애봉이";
	}
	
	public String papa(int aa) {
		
		System.out.println("JoSuk.papa 실행 : "+aa);
		return "조철왕";
	}
}
