package utez.edu.mx.unidad3.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;
@Configuration
@EnableWebSecurity

public class MainSecurity {


    @Bean
    public SecurityFilterChain doFilterInternal(HttpSecurity http) throws Exception{
        http.csrf(c-> c.disable()).cors(c -> c.configurationSource(corsRegistry()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/client/**").hasRole("ADMIN")
                        .requestMatchers("/api/cede/**").hasRole("EMPLOYEE")
                        .requestMatchers(
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/v3/api-docs.yaml",
                                "/swagger-resources/**",
                                "/webjars/**"
                        ).hasAnyRole("DEV", "ADMIN")
                        .anyRequest().authenticated()

                );

        return http.build();
    }

    private CorsConfigurationSource corsRegistry(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(false);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;

    }
/*
    @Bean
    public UserDetailsService userDetailsService(){
        //Comfigurar usarios de basic

        UserDetails admin = User.builder()
                .username("superadmin")
                .password(passwordEncoder().encode("root"))
                .roles("ADMIN")
                .build();
        UserDetails emplove = User.builder()
                .username("Martin08")
                .password(passwordEncoder().encode("root"))
                .roles("EMPLOYEE")
                .build();
        UserDetails swaggerAdmin = User.builder()
                .username("superadmin")
                .password(passwordEncoder().encode("root"))
                .roles("DEV")
                .build();

        return new InMemoryUserDetailsManager(admin, emplove, swaggerAdmin);
    }
*/
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
