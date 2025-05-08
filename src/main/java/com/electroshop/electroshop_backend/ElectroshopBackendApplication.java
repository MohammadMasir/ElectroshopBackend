package com.electroshop.electroshop_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class ElectroshopBackendApplication implements WebMvcConfigurer {
	
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Electroshop API")
                .version("1.0")
                .description("API documentation for ElectroShop App")
                .contact(new Contact()
                        .name("Shaikh Masir")
                        .email("send2masir@gmail.com")))
                .externalDocs(new ExternalDocumentation()
                    .description("Project Documentation")
                    .url("https://github.com/MohammadMasir/ElectroShop"));
            		
    }

	public static void main(String[] args) {
		SpringApplication.run(ElectroshopBackendApplication.class, args);
	}

}
