package pl.training.orders.adapters.output.warehouse;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.training.orders.ports.model.GetProductFailedException;
import pl.training.orders.ports.model.Product;
import pl.training.orders.ports.output.ProductsProvider;

import java.util.Optional;

@Primary
@Component
@Log
@RequiredArgsConstructor
public class RestTemplateProductsProviderAdapter implements ProductsProvider {

    private final RestTemplate restTemplate;
    private final WarehouseProductMapper mapper;

    @Value("${api.products}")
    @Setter
    private String productsApi;

    @Override
    public Optional<Product> getById(Long id) {
        try {
            var productDto = restTemplate.getForObject("%s/%d".formatted(productsApi, id), ProductDto.class);
            return Optional.ofNullable(productDto)
                    .map(mapper::toDomain);
        } catch (RestClientException restClientException) {
            log.info(restClientException.getMessage());
            throw new GetProductFailedException();
        }
    }

}
