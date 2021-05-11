package edu.coursework.enterprises.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    //@Bean
    public OpenAPI stadiumOpenApi(){

        return new OpenAPI().
                info(
                        new Info()
                                .title("Курсовий проект")
                                .version("1.0")
                                .contact(new Contact()
                                        .name("Bogdan")
                                        .url("my-site.cv.ua"))

                );
    }
}
