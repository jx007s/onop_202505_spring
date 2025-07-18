package aop_p.adv_p;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundADV {

	Object arTest(ProceedingJoinPoint joinpoint) {
		Object res = null;
		
		System.out.println(">>> arTest 실행 ");
		
		return res;
	}
}
