package anno_p.parts.another;

import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
@ToString
public class Wing {

	String name = "독수리날개";
	String material = "비브라늄";
}


//@Component("cycy") //같은 이름으로 bean이 설정되어선 안됀다.
@ToString
class Cylinder{
	String name = "과일이었지롱";
}
