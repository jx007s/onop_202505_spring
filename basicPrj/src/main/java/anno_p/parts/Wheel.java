package anno_p.parts;

import org.springframework.stereotype.Component;

import lombok.ToString;

public interface Wheel {

}


@Component
@ToString
class WW1 implements FomulaWheel{
	String name = "금호타이어";
}

@Component
@ToString
class WW2 implements FomulaWheel{
	String name = "금호타이거";
}

@Component
@ToString
class WW3 implements FomulaWheel{
	String name = "금호사자";
}

@Component
@ToString
class WW4 implements FomulaWheel{
	String name = "금호안타이거";
}


@Component
@ToString
class WW5 implements Wheel{
	String name = "한국타이어";
}

@Component
@ToString
class WW6 implements Wheel{
	String name = "중국타이어";
}
