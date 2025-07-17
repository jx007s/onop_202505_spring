package anno_p.airplane;

import org.springframework.stereotype.Component;

import anno_p.parts.Engine;
import anno_p.parts.another.Wing;
import jakarta.annotation.Resource;
import lombok.ToString;

@Component
@ToString
public class Cessna {
	@Resource
	Engine ee;
	
	@Resource
	Wing ww;

	String name = "작은비행기";
}
