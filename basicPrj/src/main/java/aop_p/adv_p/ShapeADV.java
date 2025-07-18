package aop_p.adv_p;


import org.aspectj.lang.JoinPoint;

import aop_p.shape.ShapeData;
import jakarta.annotation.Resource;


public class ShapeADV {
	
	@Resource
	ShapeData shData;

	void afterRet(JoinPoint joinpoint, Object rt) {
		//System.out.println(">>> afterRet 실행 :"+joinpoint.toString());
		//System.out.println("\t "+rt );
		
		shData.add((int)rt);
		
		
	}
	
	
}
