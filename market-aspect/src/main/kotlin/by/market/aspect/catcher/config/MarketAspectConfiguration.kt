package by.market.aspect.catcher.config

import by.market.aspect.catcher.CatcherAspect
import by.market.aspect.catcher.service.ReflectionMethodArgumentService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy

@Configuration
@EnableAspectJAutoProxy
open class MarketAspectConfiguration {

    @Bean
    open fun catcherAspect(reflectionMethodArgumentService: ReflectionMethodArgumentService): CatcherAspect {
        return CatcherAspect(reflectionMethodArgumentService)
    }

}