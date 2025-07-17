package anno_p.airplane;

import java.util.List;

import org.springframework.stereotype.Component;

import anno_p.parts.another.Wing;
import jakarta.annotation.Resource;
import lombok.ToString;

@Component
@ToString
class W1 extends Wing{
	String name = "핫크리스피";
}

@Component
@ToString
class W2 extends Wing{
	int price = 7800;
}

@Component
@ToString
class W3 extends Wing{
	boolean chk = true;
}

@Component
@ToString
public class Helicopter {
	String name = "AH-64";
	
	@Resource
	List<Wing> wings;
}
