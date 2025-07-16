package di_p;

import java.util.List;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
class Handle{
	String name, color;
}

@Setter
@ToString
class Wheel{
	String type;
	int size;
}

@Setter
@ToString
public class Car {

	String name;
	Handle hd;
	
	List<Wheel> whs;
}
