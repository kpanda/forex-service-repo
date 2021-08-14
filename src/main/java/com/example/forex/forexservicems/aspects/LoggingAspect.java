package com.example.forex.forexservicems.aspects;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Around("@annotation(Logging)")	
	public Object aroundAdviceLogging(ProceedingJoinPoint point) throws Throwable {
		System.out.println("Logging aspect logging details");
		Arrays.asList(point.getArgs()).forEach(s -> System.out.println("Print Arguments: " + s));
		long start = System.currentTimeMillis();
		Object proceed = point.proceed();
		long executionTime = System.currentTimeMillis() - start;
		System.out.printf("%s executed in %sms %s",
				point.getSignature(), executionTime, System.lineSeparator());
		return proceed;
	}
}
