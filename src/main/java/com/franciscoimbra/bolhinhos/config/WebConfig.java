package com.franciscoimbra.bolhinhos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /*registry.addMapping("/**") // aplica o CORS a todos os endpoints
                .allowedOrigins(
                        "127.0.0.1:8181",
                        "5.249.47.141",
                        "127.0.0.1:4200",
                        "192.168.1.3:4200"
                ) // permite origens específicas
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // permite métodos específicos
                .allowedHeaders("*") // permite todos os cabeçalhos
                .allowCredentials(true);*/

        registry.addMapping("/**").allowedMethods("*");

    }
}
