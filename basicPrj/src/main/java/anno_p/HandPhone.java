package anno_p;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;

@Data
class Camera{
	String name, kind;
}

@Data
class Mic{
	String type;
	boolean bluetooth;
}

class Screen{
	int size;
}


@ToString
public class HandPhone {
	
	@Autowired  //di 자동설정 , setter 메소드 없어도 가능
				// 1. byName 2. byType
	Camera cam;
	
	Mic mm;
	
	//required = false: 필수 요소가 아님 - 있으면 결합, 없으면 결합안함
	//required = true 혹은 생략: 필수 요소- 없으면 에러
	@Autowired(required = false)  
	Screen scr;
	
	@Setter
	String name;

	@Autowired
	@Qualifier("mm1")  //di 대상 bean 명시
	public void setMm(Mic mm) {
		this.mm = mm;
	}
	
	
	
}
