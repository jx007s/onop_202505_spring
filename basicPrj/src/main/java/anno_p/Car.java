package anno_p;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.Resource;
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


@ToString
public class Car {

	@Setter
	String name;
	
	
	
	//@Resource(required = false)  --> 에러  // 반드시 필수
	// 우선순위 1. name지정 2. byName 3. byType
	@Resource(name="hh2")  // name : bean 지정
	Handle hd;
	
	@Autowired
	List<Wheel> whs;
}
