package di_p;


class OneBean{
	String origin, taste;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	@Override
	public String toString() {
		return "OneBean [origin=" + origin + ", taste=" + taste + "]";
	}
}

public class Coffee {
	OneBean ob;
	String name;
	int price;
	public void setOb(OneBean ob) {
		this.ob = ob;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Coffee [ob=" + ob + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
