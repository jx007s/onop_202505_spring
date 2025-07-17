package anno_p.car_p;

import java.util.List;

import org.springframework.stereotype.Component;

import anno_p.parts.Booster;
import anno_p.parts.FomulaWheel;
import anno_p.parts.Luggage;
import anno_p.parts.Wheel;
import jakarta.annotation.Resource;
import lombok.ToString;

@Component
@ToString
public class F1 {
	String name = "수퍼아스라다";
	
	@Resource
	List<FomulaWheel> whs;
	
	@Resource
	Booster bst;
}


@Component
@ToString
class Truck {
	String name = "봉고르기니무얼실을라고";
	
	@Resource
	List<Wheel> whs;
	
	@Resource
	Luggage lgg;
}
