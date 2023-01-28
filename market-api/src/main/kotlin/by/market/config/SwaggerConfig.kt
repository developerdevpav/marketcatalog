package by.market.config

import by.market.config.properties.SwaggerContactProperties
import by.market.config.properties.SwaggerPageProperties
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class SwaggerConfig {

    @Bean("swaggerOperApi")
    fun swaggerOpenApi(swaggerContact: Contact, swaggerPageProperties: SwaggerPageProperties): OpenAPI = OpenAPI()
        .info(
            Info()
                .title(swaggerPageProperties.title)
                .version(swaggerPageProperties.version)
                .contact(swaggerContact)
        )

    @Bean("swaggerContact")
    fun swaggerContact(swaggerContactProperties: SwaggerContactProperties): Contact? =
        Contact()
            .email(swaggerContactProperties.email)
            .name(swaggerContactProperties.name)
            .url(swaggerContactProperties.url)

}
