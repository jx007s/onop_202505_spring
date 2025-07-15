package di_p;


class Camera{
	String name, kind;

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


public class HandPhone {
	
	Camera cam;

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



	@Override
	public String toString() {
		return "HandPhone [cam=" + cam + ", name=" + name + ", price=" + price + "]";
	}

}
