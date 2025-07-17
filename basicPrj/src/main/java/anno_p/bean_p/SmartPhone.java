package anno_p.bean_p;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
class SmCamera{
	String name, kind;
}

@Setter
@ToString
public class SmartPhone {

	String name;
	SmCamera cam;
}
