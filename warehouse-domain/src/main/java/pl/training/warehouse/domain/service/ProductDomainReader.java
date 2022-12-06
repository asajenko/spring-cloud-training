package pl.training.warehouse.domain.service;

import pl.training.warehouse.domain.model.ProductDomain;

import java.util.Optional;

public interface ProductDomainReader {

    Optional<ProductDomain> getById(Long id);

}
