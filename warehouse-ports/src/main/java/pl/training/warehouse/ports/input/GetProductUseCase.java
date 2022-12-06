package pl.training.warehouse.ports.input;

import pl.training.warehouse.ports.model.Product;

public interface GetProductUseCase {

    Product getById(Long id);

}
