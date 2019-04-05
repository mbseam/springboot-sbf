package com.mb.sbf;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths() {
        return regex("/rental.*");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("DvdRental Application Api")
                .description("DvdRental Application Api reference for developers")
                .termsOfServiceUrl("http://dvdrentalonline.com")
                .contact("mbseam@gmail.com")
                .license("DvdRental Application License")
                .licenseUrl("mbseam@gmail.com").version("1.0").build();
    }

}
