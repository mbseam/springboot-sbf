package com.mb.sbf;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication(scanBasePackages = {
         "com.mb.sbf.controller",
         "com.mb.sbf.service",
         "com.mb.sbf.repo",
         "com.mb.sbf.model",
         "com.mb.handler",
         "com.mb.filter"
})
@EnableSwagger2
@EnableEurekaClient
public class App {

    public static void main(String[] args) {
        run(App.class, args);
    }

    @Bean
    public Mapper mapper() {
        return new DozerBeanMapper();
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.mb.sbf")).build();
    }
}