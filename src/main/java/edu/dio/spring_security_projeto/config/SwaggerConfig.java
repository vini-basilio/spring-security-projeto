package edu.dio.spring_security_projeto.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de transações")
                        .version("1.0")
                        .description("API para gerenciamento de transações feita para o desafio técnico do Itaú")
                        .contact(new Contact()
                                .name("Vinícius Basílio")
                                .email("vini.ba.dev@gmail.com")));
    }
}