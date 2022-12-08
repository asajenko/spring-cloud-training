package pl.training.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.training.shop.warehouse.ProductEventMessage;

import java.util.function.Consumer;

@EnableCaching
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
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("products");
    }

    @Bean
    public Consumer<ProductEventMessage> productsListener(CacheManager cacheManager) {
        /*return productEventMessage -> {
            log.info("New message: " + productEventMessage);
        };*/
        return new ProductsListener(cacheManager.getCache("products"));
    }

    @RequiredArgsConstructor
    class ProductsListener implements Consumer<ProductEventMessage> {

        private final Cache cache;

        @Override
        public void accept(ProductEventMessage productEventMessage) {
            log.info("New message: " + productEventMessage);
            log.info("Clearing cache...");
            cache.clear();
        }

    }

    @Bean
    public KeycloakConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

    @Bean
    public RequestMatcher apiMatcher(@Value("${apiPath}") String apiPath) {
        return new AntPathRequestMatcher(apiPath);
    }

}
