package by.market

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
class CatalogMarket {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(CatalogMarket::class.java, *args)
        }
    }

}

