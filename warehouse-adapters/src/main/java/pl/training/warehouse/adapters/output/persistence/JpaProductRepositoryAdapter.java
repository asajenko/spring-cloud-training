package pl.training.warehouse.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.training.warehouse.ports.model.Product;
import pl.training.warehouse.ports.output.ProductReader;

import java.util.Optional;

@Transactional // (propagation = Propagation.MANDATORY)
@Component
@RequiredArgsConstructor
public class JpaProductRepositoryAdapter implements ProductReader {

    private final JpaProductRepository productRepository;
    private final JpaProductRepositoryMapper mapper;

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id)
                .map(mapper::toDomain);
    }

}
