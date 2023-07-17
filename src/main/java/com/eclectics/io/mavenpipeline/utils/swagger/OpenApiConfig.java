package com.eclectics.io.mavenpipeline.utils.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI departmentOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("ECLECTICS 3.0 INTERNATIONALE")
                        .description("MAVEN PIPELINE APIs TEST")
                        .version("v3.0"));
    }
}
