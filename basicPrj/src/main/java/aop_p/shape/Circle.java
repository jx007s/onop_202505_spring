package aop_p.shape;

import org.springframework.stereotype.Component;

@Component
public class Circle{

	public int calc(int r) {
		System.out.println("원 계산:"+r);
		
		return (int)(Math.PI * r * r);
	}
}

