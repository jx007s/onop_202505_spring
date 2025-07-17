package anno_p;

import org.springframework.beans.factory.annotation.Autowired;

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

@ToString
public class HandPhone {
	
	@Autowired  //di 자동설정 , setter 메소드 없어도 가능
	Camera cam;
	
	Mic mm;
	
	@Setter
	String name;

	@Autowired
	public void setMm(Mic mm) {
		this.mm = mm;
	}
	
	
	
}
