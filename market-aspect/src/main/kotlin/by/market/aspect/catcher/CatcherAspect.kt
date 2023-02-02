package by.market.aspect.catcher

import by.market.aspect.annotation.ReqArg
import by.market.aspect.catcher.service.ReflectionMethodArgumentService
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature

@Aspect
class CatcherAspect constructor(private val reflectionMethodArgumentService: ReflectionMethodArgumentService) {

    @Around("@annotation(by.market.aspect.catcher.annotation.Catcher)")
    @Throws(Throwable::class)
    fun catching(proceedingJoinPoint: ProceedingJoinPoint): Any {
        val signature = proceedingJoinPoint.signature as MethodSignature
        val method = signature.method
        val arguments = proceedingJoinPoint.args
        val parameters = method.parameters

        val arg = reflectionMethodArgumentService.getArgByAnnotation(arguments, parameters, ReqArg::class.java)

        println(arg)

        return proceedingJoinPoint.proceed()
    }

}