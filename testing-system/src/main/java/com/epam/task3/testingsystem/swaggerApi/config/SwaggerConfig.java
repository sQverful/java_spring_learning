package com.epam.task3.testingsystem.swaggerApi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api-v1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.epam.task3.testingsystem.controller"))
                .paths(PathSelectors.ant("/api/v1/**"))
                .build()
                .apiInfo(apiDetails());
    }

    //The following fixes conflict between swagger and hateoas
    @Bean
    public LinkDiscoverers discoverers() {
        List<LinkDiscoverer> plugins = new ArrayList<>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Testing System API Documentation",
                "Pet project",
                "1.0",
                "Free to use",
                new Contact("Dorosh Volodymyr", "https://github.com/sQverful", "vov.dorosh@gmail.com"),
                "",
                "",
                Collections.emptyList()
        );
    }

}
