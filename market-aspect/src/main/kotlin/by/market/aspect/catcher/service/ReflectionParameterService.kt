package by.market.aspect.catcher.service

import org.springframework.stereotype.Component
import java.lang.reflect.Parameter
import java.util.*


interface ReflectionParameterService {

    fun isAnnotated(parameter: Parameter, classAnnotation: Class<out Annotation>): Boolean

    fun indexOfFirstByAnnotation(parameters: Array<Parameter>, classAnnotation: Class<out Annotation>): Int

    fun indexOfByAnnotation(parameters: Array<Parameter>, classAnnotation: Class<out Annotation>): List<Int>

}

@Component
open class ReflectionParameterServiceImpl : ReflectionParameterService {

    override fun isAnnotated(parameter: Parameter, classAnnotation: Class<out Annotation>): Boolean {
        require(Objects.nonNull(parameter)) { "Parameter is null" }

        return Arrays.stream(parameter.annotations)
            .anyMatch { annotation: Annotation -> annotation.javaClass == classAnnotation }
    }

    override fun indexOfFirstByAnnotation(parameters: Array<Parameter>, classAnnotation: Class<out Annotation>): Int =
        parameters.indexOfFirst { this.isAnnotated(it, classAnnotation) }

    override fun indexOfByAnnotation(parameters: Array<Parameter>, classAnnotation: Class<out Annotation>): List<Int> {
        return parameters
            .mapIndexed { index, parameter -> if (this.isAnnotated(parameter, classAnnotation)) index else null }
            .filterNotNull()
            .toList()
    }

}