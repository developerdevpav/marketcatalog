package by.market.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "swagger.contact-info")
class SwaggerContactProperties(val url: String, val name: String, val email: String)