package anno_p.bean_p;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class BeanInit {
	
	@Bean
	SmCamera cam1() {
		SmCamera res = new SmCamera();
		res.name = "코닥";
		res.kind = "똑딱이";
		return res;
	}
	
	@Bean
	SmCamera cc() {
		SmCamera res = new SmCamera();
		res.name = "삼성";
		res.kind = "핸드폰용";
		return res;
	}
	
	
	@Bean	// 메소드 리턴값으로  bean 설정  
			//bean 이름 : 메소드명
	SmartPhone ph1() {
		SmartPhone res = new SmartPhone();
		res.name = "프라다폰";
		return res;
	}
	
	@Bean(name = "sp2") //bean 이름 변경
	SmartPhone ph2() {
		SmartPhone res = new SmartPhone();
		res.name = "키즈폰";
		return res;
	}
	
	@Bean
	SmartPhone ph3(@Qualifier("cc")SmCamera cc) { //매개변수로 bean을 자동설정
						// bean 중첩시 byName > byType  순으로 철;
						// 가져올 bean의 이름을 @Qualifier("cc") 로 명시적 설정 필요
		SmartPhone res = new SmartPhone();
		res.name = "리셀웨폰";
		res.cam = cc;
		return res;
	}
	
	@Bean
	ArrayList<SmCamera> cams(SmCamera ... arr){ //매개변수로 같은 type bean 가져옴
		
		System.out.println("cams 실행 : "+arr);
		System.out.println(Arrays.toString(arr));
		ArrayList<SmCamera> res = new ArrayList<>();
		
		for (SmCamera sc : arr) {
			res.add(sc);
		}
		
		return res;
	}
	
	@Bean
	ArrayList<SmCamera> cams2(ArrayList<SmCamera> arr){ //매개변수로 같은 type bean 가져옴
		
		return arr;
	}
	

}
