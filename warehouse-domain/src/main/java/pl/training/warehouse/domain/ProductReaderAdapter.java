package pl.training.warehouse.domain;

import lombok.RequiredArgsConstructor;
import pl.training.warehouse.ports.ProductReader;

import java.util.Optional;

@RequiredArgsConstructor
class ProductReaderAdapter {

    private final ProductReader productReader;
    private final ProductDomainMapper mapper;

    Optional<ProductDomain> getById(Long id) {
        return productReader.getById(id)
                .map(mapper::toDomain);
    }

}
