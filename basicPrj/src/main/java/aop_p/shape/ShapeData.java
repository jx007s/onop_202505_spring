package aop_p.shape;

import org.springframework.stereotype.Component;


import lombok.ToString;

@Component
@ToString
public class ShapeData {

	int cnt =0 , area = 0;
	
	public void add(int area) {
		cnt++;
		this.area += area;
	}
}
