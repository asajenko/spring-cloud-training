package pl.training.warehouse.ports.output;

import pl.training.warehouse.ports.model.Product;

import java.util.Optional;

public interface ProductReader {

    Optional<Product> getById(Long id);

}
