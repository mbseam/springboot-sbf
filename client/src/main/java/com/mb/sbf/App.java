package com.mb.sbf;

import com.mb.config.PostgreDBConfig;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication(scanBasePackages = {
         "com.mb.sbf.controller",
         "com.mb.sbf.service",
         "com.mb.sbf.repo",
         "com.mb.sbf.model",
         "com.mb.handler",
         "com.mb.filter",
         "com.mb.config"
},
        exclude = {
            DataSourceAutoConfiguration.class
})
@EnableSwagger2
@EnableEurekaClient
public class App implements ApplicationRunner {

    private static final Logger LOG = Logger.getLogger(ApplicationRunner.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(ApplicationArguments arg0) throws Exception {
        LOG.log(Level.SEVERE, "Application started");
        System.out.println("SBF Application started!");
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