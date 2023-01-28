package by.market.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "swagger.page-info")
class SwaggerPageProperties(val title: String, val version: String)