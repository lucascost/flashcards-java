package com.lucascost.flashcards.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringdocConfig {
    @Bean
    public OpenAPI springOpenAPI(){
        return new OpenAPI()
                .info(new Info().title("FlashCards API")
                .version("1.0"))
                .externalDocs(new ExternalDocumentation()
                .description("Link para o repositório")
                .url("https://github.com/lucascost/flashcards-java"));
    }
}
