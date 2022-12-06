package pl.training.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.training.warehouse.adapters.persistence.jpa.JpaProductRepository;
import pl.training.warehouse.adapters.persistence.jpa.ProductEntity;
import pl.training.warehouse.domain.DefaultProductServiceFactory;
import pl.training.warehouse.ports.GetProductUseCase;
import pl.training.warehouse.ports.ProductReader;
import pl.training.warehouse.ports.ProductServiceFactory;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@EnableJpaRepositories(basePackages = "pl.training")
@EntityScan("pl.training")
@Configuration
public class WarehouseConfiguration implements WebMvcConfigurer {

    private static final ProductServiceFactory PRODUCT_SERVICE_FACTORY = new DefaultProductServiceFactory();

    @Bean
    public GetProductUseCase getProductUseCase(ProductReader productReader) {
        return PRODUCT_SERVICE_FACTORY.create(productReader);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("http://localhost:4200");
    }

    @Autowired
    JpaProductRepository productRepository;

    @PostConstruct
    public void init() {
        if (productRepository.findById(1L).isEmpty()) {
            var product = new ProductEntity();
            product.setId(1L);
            product.setName("Spring in action");
            product.setValue(BigDecimal.valueOf(200));
            productRepository.save(product);
        }
    }

}
