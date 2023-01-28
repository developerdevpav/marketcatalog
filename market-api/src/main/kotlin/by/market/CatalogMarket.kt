package by.market

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
@EnableJpaRepositories
class CatalogMarket {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(CatalogMarket::class.java, *args)
        }
    }

}

