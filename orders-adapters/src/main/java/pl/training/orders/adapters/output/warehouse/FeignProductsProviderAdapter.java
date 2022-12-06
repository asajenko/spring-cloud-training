package pl.training.orders.adapters.output.warehouse;

import feign.FeignException.FeignClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.training.orders.ports.model.GetProductFailedException;
import pl.training.orders.ports.model.Product;
import pl.training.orders.ports.output.ProductsProvider;

import java.util.Optional;

@Primary
@Component
@Log
@RequiredArgsConstructor
public class FeignProductsProviderAdapter implements ProductsProvider {

    private final ProductsApi productsApi;
    private final WarehouseProductMapper mapper;

    @Override
    public Optional<Product> getById(Long id) {
        try {
            var productDto = productsApi.getById(id);
            return Optional.ofNullable(productDto)
                    .map(mapper::toDomain);
        } catch (FeignClientException feignClientException) {
            log.info(feignClientException.getMessage());
            throw new GetProductFailedException();
        }
    }

}
