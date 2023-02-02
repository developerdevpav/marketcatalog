package by.market.aspect.catcher.service

import org.springframework.stereotype.Component
import java.lang.reflect.Parameter

interface ReflectionMethodArgumentService {

    fun getArgsByAnnotation(args: Array<Any>, parameters: Array<Parameter>, annotation: Class<out Annotation>): Any

    fun getArgByAnnotation(args: Array<Any>, parameters: Array<Parameter>, annotation: Class<out Annotation>): Any

}

@Component
class ReflectionMethodArgumentServiceImpl(val reflectionParameterService: ReflectionParameterService) :
    ReflectionMethodArgumentService {

    override fun getArgsByAnnotation(
        args: Array<Any>,
        parameters: Array<Parameter>,
        annotation: Class<out Annotation>
    ): List<Any> {
        val paramIndexes = reflectionParameterService.indexOfByAnnotation(parameters, annotation).toSet()

        return args.filterIndexed { index, _ -> paramIndexes.contains(index) }
    }

    override fun getArgByAnnotation(
        args: Array<Any>,
        parameters: Array<Parameter>,
        annotation: Class<out Annotation>
    ): Any {
        val paramIndex = reflectionParameterService.indexOfFirstByAnnotation(parameters, annotation)

        if (paramIndex >= args.size || paramIndex < 0) {
            throw IllegalArgumentException("Parameter not found in args")
        }

        return args[paramIndex]
    }

}