package pl.training.warehouse.domain.adapters.output;

import lombok.RequiredArgsConstructor;
import pl.training.warehouse.domain.adapters.ProductDomainMapper;
import pl.training.warehouse.domain.model.ProductDomain;
import pl.training.warehouse.domain.service.ProductDomainReader;
import pl.training.warehouse.ports.output.ProductReader;

import java.util.Optional;

@RequiredArgsConstructor
public class ProductReaderAdapter implements ProductDomainReader {

    private final ProductReader productReader;
    private final ProductDomainMapper mapper;

    @Override
    public Optional<ProductDomain> getById(Long id) {
        return productReader.getById(id)
                .map(mapper::toDomain);
    }

}
