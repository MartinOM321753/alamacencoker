package utez.edu.mx.unidad3.utlis;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI Config(){

        return new OpenAPI().info(new Info().title("API REST de Almacenes")
                .description("Documentacion de los endpoints de almacenes")
                .version("V1.0"));
    }



}
