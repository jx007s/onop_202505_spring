package anno_p.parts;

import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
@ToString
public class ExPlug extends Plug{
	String name = "비싼플러그";
	int money = 100;
}
