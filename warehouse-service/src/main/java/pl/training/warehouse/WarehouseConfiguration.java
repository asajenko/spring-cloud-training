package pl.training.warehouse;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.training.warehouse.adapters.persistence.JpaProductRepository;
import pl.training.warehouse.adapters.persistence.JpaProductRepositoryAdapter;
import pl.training.warehouse.adapters.persistence.JpaProductRepositoryMapper;
import pl.training.warehouse.adapters.persistence.ProductEntity;
import pl.training.warehouse.domain.adapters.ProductDomainMapper;
import pl.training.warehouse.domain.adapters.input.GetProductUseCaseAdapter;
import pl.training.warehouse.domain.adapters.output.ProductReaderAdapter;
import pl.training.warehouse.domain.service.GetProductService;
import pl.training.warehouse.ports.input.GetProductUseCase;
import pl.training.warehouse.ports.output.ProductReader;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@EnableJpaRepositories(basePackages = "pl.training")
@EntityScan("pl.training")
@Configuration
public class WarehouseConfiguration implements WebMvcConfigurer {

    @Bean
    public ProductReader productReader(JpaProductRepository jpaProductRepository, JpaProductRepositoryMapper mapper) {
        return new JpaProductRepositoryAdapter(jpaProductRepository, mapper);
    }


    @Bean
    public GetProductUseCase getProductUseCase(ProductReader productReader) {
        var productDomainMapper = Mappers.getMapper(ProductDomainMapper.class);
        var productReaderAdapter = new ProductReaderAdapter(productReader, productDomainMapper);
        var productServer = new GetProductService(productReaderAdapter);
        return new GetProductUseCaseAdapter(productServer, productDomainMapper);
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
