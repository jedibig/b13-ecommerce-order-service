package com.b13.orderservice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;

import com.b13.orderservice.exception.DaoException;

@Aspect
public class OrderAspect {
   
    @Around("within(com.b13.orderservice.dao.*)")
 	public Object translateToDao(ProceedingJoinPoint pjp) throws Throwable {
 		try {
 			return pjp.proceed();
 		} catch (DataAccessException e) {
 			throw new DaoException(e);
 		}
 	}
}
