package by.market.aspect.catcher;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CatcherAspect {

    @Around("@annotation(by.market.aspect.catcher.annotation.Catcher)")
    public Object catching(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return proceedingJoinPoint.proceed();
    }

}
