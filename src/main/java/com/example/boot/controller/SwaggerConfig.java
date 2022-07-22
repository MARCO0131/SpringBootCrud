package com.example.boot.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
@EnableWebMvc
public class
SwaggerConfig extends WebMvcConfigurationSupport {


 public static final Contact CONTACT = new Contact("Ritesh", "https://github.com/MARCO0131",
         "riteshbadgotya@gmail.com");
 public static final ApiInfo DEFAULT_API = new ApiInfo("swagger", "Swagger Documentation", "1.0", "urn:tos", CONTACT,
         "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
 public static final Set<String> consumes = new HashSet<>(Arrays.asList("application/json"));
 public static final Set<String> produces = new HashSet<String>(Arrays.asList("application/json"));

 @Bean
 public Docket api() {
  return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API).consumes(consumes).produces(produces);
 }
}
