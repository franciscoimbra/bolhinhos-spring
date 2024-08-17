package com.franciscoimbra.bolhinhos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // aplica o CORS a todos os endpoints
                .allowedOrigins("http://localhost:8181","5.249.47.141","http://localhost:4200") // permite origens específicas
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // permite métodos específicos
                .allowedHeaders("*") // permite todos os cabeçalhos
                .allowCredentials(true);
    }
}
