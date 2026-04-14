package Quixaba.dev.Gymsys.Configuration;

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
                        .title("GYM SYSTEM API") // <
                        .version("v1.0.0") //
                        .description("Documentação oficial da API do sistema de gerenciamento de academia Gymsys.")
                        .contact(new Contact()
                                .name("Quixaba Dev")
                                .email("Savioquixabaone@gmail.com")));
    }
}
