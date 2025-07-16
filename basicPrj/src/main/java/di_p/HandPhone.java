package di_p;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;

class Camera{
	String name, kind;
	
	public Camera() {
		System.out.println("카메라 기본 생성자");
	}

	public Camera(String name, String kind) {
		System.out.println("카메라 사용자정의 생성자 : "+name+","+kind);
		this.name = name;
		this.kind = kind;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return "Camera [name=" + name + ", kind=" + kind + "]";
	}
	
	
}

@Data
class Mic{
	String type;
	boolean bluetooth;
}

@Data
class Screen{
	String kind;
	int size;
}


@ToString
class Computer{
	Camera cam;
	Screen scr;
	
	@Setter
	String name;

	public Computer(Camera cam, Screen scr) {
		this.cam = cam;
		this.scr = scr;
	}	
}

@ToString
class Tablet{
	Camera cam;
	Screen scr;
	Mic mm;
	
	@Setter
	String name;

	public Tablet(Camera cam, Screen scr) {
		System.out.println("Tablet  cam, scr 생성자");
		this.cam = cam;
		this.scr = scr;
	}
	
	public Tablet(Camera cam) {
		System.out.println("Tablet  cam 생성자");
		this.cam = cam;
	}
	

	
	// 생성자 자동 결합인 경우 , 결합이 가능한 생성자가 다수이면서 매개변수 갯수가 같을 경우 마지막 생성자 호출
	//                                                매개변수가 많은 생성자가 우선 호출
	
	// 호출 우선순위 -- 1
	public Tablet(Mic mm, Screen scr) {
		System.out.println("Tablet  mm , scr 생성자");
		this.mm = mm;
		this.scr = scr;
	}
	
	// 호출 우선순위  -- 3
	public Tablet(Mic mm) {
		System.out.println("Tablet  mm 생성자");
		this.mm = mm;
	}
	// 호출 우선순위  -- 2	
	public Tablet(Screen scr) {
		System.out.println("Tablet  scr 생성자");
		this.scr = scr;
	}
	
	
}





@Setter
@ToString
public class HandPhone {
	
	Camera cam;
	Mic mm;
	Screen scr;

	String name;
	int price;
	
	public HandPhone() {
		System.out.println("HandPhone 기본 생성자---");
	}
	
	

	public void setCam(Camera cam) {
		this.cam = cam;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public HandPhone(Camera cam, Screen scr) {
		
		System.out.println("HandPhone cam,scr 정의 생성자");
		this.cam = cam;
		this.scr = scr;
	}

}
