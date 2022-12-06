package pl.training.warehouse.ports;

import java.util.Optional;

public interface ProductReader {

    Optional<Product> getById(Long id);

}
