package aop_p.adv_p;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class PointADV {

	//void beforeee(ProceedingJoinPoint joinpoint) { 에러발생
	void beforeee(JoinPoint joinpoint) {
		System.out.println(">>> beforeee 실행 :"+joinpoint.toString());
		System.out.println("\t "+joinpoint.getSignature());
		System.out.println("\t "+joinpoint.getSignature().getName());
		System.out.println("\t "+joinpoint.getTarget());
		System.out.println("\t "+Arrays.toString(joinpoint.getArgs()) );
		
		//joinpoint.proceed();  없음
	}
	
	
	void afterRet(JoinPoint joinpoint, Object rt) {
		System.out.println(">>> afterRet 실행 :"+joinpoint.toString());
		System.out.println("\t "+joinpoint.getSignature());
		System.out.println("\t "+joinpoint.getSignature().getName());
		System.out.println("\t "+joinpoint.getTarget());
		System.out.println("\t "+Arrays.toString(joinpoint.getArgs()) );
		System.out.println("\t "+rt );
		//rt = "플란다스의개";  의미없음
		//joinpoint.proceed();  없음
	}
	
	
	void afterErr(JoinPoint joinpoint, Throwable ee) {
		System.out.println(">>> afterErr 실행 :"+joinpoint.toString());
		System.out.println("\t "+joinpoint.getSignature());
		System.out.println("\t "+joinpoint.getSignature().getName());
		System.out.println("\t "+joinpoint.getTarget());
		System.out.println("\t "+Arrays.toString(joinpoint.getArgs()) );
		System.out.println("\t "+ee );

	}
	
	
	void afterrrr(JoinPoint joinpoint) {
		System.out.println(">>> afterrrr 실행 :"+joinpoint.toString());
		System.out.println("\t "+joinpoint.getSignature());
		System.out.println("\t "+joinpoint.getSignature().getName());
		System.out.println("\t "+joinpoint.getTarget());
		System.out.println("\t "+Arrays.toString(joinpoint.getArgs()) );
	}
	
	
}
