package com.salim.cascadetype.config.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info().title("Cascade Type"))
                .servers(List.of(
                        new Server().url("http://localhost:8080/")
//                        new Server().url("https://dev-clinical-intake.allevia.md"),
//                        new Server().url("https://stg-clinical-intake.allevia.md")
                ));
//                .addSecurityItem(new SecurityRequirement().addList("JavaInUseSecurityScheme"))
//                .components(new Components().addSecuritySchemes("JavaInUseSecurityScheme", new SecurityScheme()
//                        .name("JavaInUseSecurityScheme").type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));

    }
}
