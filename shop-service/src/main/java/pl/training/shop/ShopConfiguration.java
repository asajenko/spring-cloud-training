package pl.training.shop;

import lombok.extern.java.Log;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.training.shop.warehouse.ProductEventMessage;

import java.util.function.Consumer;

@EnableFeignClients("pl.training")
@Configuration
@Log
public class ShopConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("http://localhost:4200");
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Consumer<ProductEventMessage> productsListener() {
        return productEventMessage -> {
            log.info("New message: " + productEventMessage);
        };
    }

}
