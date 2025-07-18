package aop_p.adv_p;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundADV {

	Object arTest(ProceedingJoinPoint joinpoint) {
		Object res = null;
		
		System.out.println(">>> arTest 실행 :"+joinpoint.toString());
		System.out.println("\t "+joinpoint.getSignature());
		System.out.println("\t "+joinpoint.getSignature().getName());
		System.out.println("\t "+joinpoint.getTarget());
		System.out.println("\t "+Arrays.toString(joinpoint.getArgs()) );
		
		
		try {
			if(!joinpoint.getSignature().getName().equals("dog1")) {
				//실제 메소드 실행
				res = joinpoint.proceed();
				
				if(res.equals("애봉이")) {
					res = "조준";
				}
			}
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
}
