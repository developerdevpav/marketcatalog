package by.market.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class SwaggerConfig {

  @Bean
  fun apiInfo(): OpenAPI? {
    val description = Info().title("OpenApi Market Catalog").version("1.0.0")
            .contact(
                    Contact()
                            .email("devpavdeveloper@yandex.ru")
                            .name("Павел Талайко")
                            .url("https://github.com/developerdevpav/marketcatalog")
            )
    return OpenAPI().info(description)
  }

  @Bean
  fun httpApi(): GroupedOpenApi? {
    return GroupedOpenApi.builder()
            .group("http")
            .pathsToMatch("/**")
            .build()
  }

}
