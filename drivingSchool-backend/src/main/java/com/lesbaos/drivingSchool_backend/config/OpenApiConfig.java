package com.lesbaos.drivingSchool_backend.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "kti service",
                        email = "ktiserviceinfos@gmail.com",
                        url = "https://geekinstitut.com"
                ),
                description = "OpenAPI documentation for Driving School",
                title = "OpenAPI Specification - Smart Geek Money",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenApiConfig {
}
