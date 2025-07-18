package aop_p.shape;

import org.springframework.stereotype.Component;


@Component
public class Rectangle{

	public int calc(int w, int h) {
		System.out.println("직사각형 계산:"+w+","+h);
		
		return w * h;
	}
}

