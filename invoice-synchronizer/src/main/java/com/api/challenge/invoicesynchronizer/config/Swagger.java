package com.api.challenge.invoicesynchronizer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("NFe API")
                .description("REST API that provides NFe information")
                .version("1.0")
                .contact(new Contact("Filipe Tagliacozzi", "", "filipednb@gmail.com"))
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.api.challenge.invoicesynchronizer.resource"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }
}
