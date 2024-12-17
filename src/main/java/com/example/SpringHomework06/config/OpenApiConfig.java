package com.example.SpringHomework06.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Spring Homework 06",
                description = "API CRUD User",
                version = "1.0.0",
                contact = @Contact(name = "Student GB", url = "https://gb.ru")
        )
)
public class OpenApiConfig {
}
