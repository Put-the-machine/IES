package org.put_the_machine.ies.cofig.prod;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Profile("prod")
@Configuration
public class ProdMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/css/**", "/js/**", "/img/**")
                .addResourceLocations("classpath:/static/css/")
                .addResourceLocations("classpath:/static/js/")
                .addResourceLocations("classpath:/static/img/")
                .setCachePeriod(1000000);
    }
}