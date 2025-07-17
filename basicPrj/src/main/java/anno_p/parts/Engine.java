package anno_p.parts;

import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import lombok.ToString;

@Component("cycy") //bean 이름 변경
@ToString
class Cylinder{
	String name = "니켈실린더";
	int cnt = 8;
}


@ToString
class Plug{
	String name = "점화플러그";
}

@Component		// bean 등록 --> class 이름의 소문자 시작이 bean 이름
@ToString
public class Engine {
	String name = "v8차저터보엔진";
	
	@Resource
	Cylinder cyd;
	
	@Resource
	Plug plug;
	
}
