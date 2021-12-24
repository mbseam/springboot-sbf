package com.mb.config;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public Sampler samplerOb() {
        return Sampler.ALWAYS_SAMPLE;
    }

    @Bean
    public RestTemplate rt() {
        return new RestTemplate();
    }
}
