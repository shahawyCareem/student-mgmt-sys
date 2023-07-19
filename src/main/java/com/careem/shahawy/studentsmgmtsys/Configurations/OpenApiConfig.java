package com.careem.shahawy.studentsmgmtsys.Configurations;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Student Management System")
                                .description("Simple Student Management System REST API")
                                .version("App version"))
            .externalDocs(
                new ExternalDocumentation()
                        .description("Student Management System Docs")
                        .url("https://shahawy.com"));
    }

    @Bean
    public GroupedOpenApi TeachersV1Api() {
        return GroupedOpenApi.builder()
                .group("Teachers v1 REST API")
                .pathsToMatch("/teachers/**")
                .build();
    }

    @Bean
    public GroupedOpenApi StudentsV1Api() {
        return GroupedOpenApi.builder()
                .group("Students v1 REST API")
                .pathsToMatch("/students/**")
                .build();
    }

    @Bean
    public GroupedOpenApi CoursesV1Api() {
        return GroupedOpenApi.builder()
                .group("Courses v1 REST API")
                .pathsToMatch("/courses/**")
                .build();
    }
}
