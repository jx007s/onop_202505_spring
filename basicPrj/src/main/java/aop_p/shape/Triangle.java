package aop_p.shape;

import org.springframework.stereotype.Component;




@Component
public class Triangle {

	public int calc(int w, int h, int a) {
		System.out.println("직각삼각형 계산:"+w+","+h+","+a);
		
		return w * h / 2;
	}
}

