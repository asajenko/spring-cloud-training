package pl.training.warehouse.domain.service;

import lombok.RequiredArgsConstructor;
import pl.training.warehouse.domain.model.ProductDomain;

@RequiredArgsConstructor
public class GetProductService {

    private final ProductDomainReader productReader;

    public ProductDomain getById(Long id) {
        return productReader.getById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

}
