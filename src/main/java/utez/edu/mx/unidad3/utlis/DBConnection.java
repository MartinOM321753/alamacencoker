package utez.edu.mx.unidad3.utlis;
/*
* @Configuration : le dice a spring que eta clase de java va a henerar una configuracion durante la ejucucion de la aplicacion,
* pero esta anotacion debe de ir con un metodo con la anotaccion
* bean que le diga que va a configurar
*
* @BEAN : le indica a spring que el metodo que retornara dicha configuracion
*
* */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConnection {
    @Value("${db.url}")
    private String DB_URL;

    @Value("${db.usaername}")
    private String DB_USER;

    @Value("${db.password}")
    private String DB_PASSWORD;

    @Bean
    public DataSource getConnection() {

        try {

            DriverManagerDataSource confiration = new DriverManagerDataSource();
            confiration.setUrl(DB_URL);
            confiration.setUsername(DB_USER);
            confiration.setPassword(DB_PASSWORD);
            confiration.setDriverClassName("com.mysql.cj.jdbc.Driver");

            return confiration;


        } catch (Exception ex) {

            System.out.println("Error al conectar a ala BD");
            ex.printStackTrace();
            return null;
        }

    }
}
