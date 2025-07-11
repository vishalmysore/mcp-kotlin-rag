package org.example.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
open class WebConfig {
    @Bean
   open fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}
