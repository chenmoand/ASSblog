package com.brageast.blog.annotation.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public abstract class BaseAtn {

    protected abstract void doBefore(JoinPoint joinPoint) throws Throwable;
    protected abstract void doAfter() throws Throwable;
    protected abstract Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable;

    public void doAfterReturning() {}
    public void doAfterThrowing() {}
}
