package pl.training.warehouse.ports.output;

import pl.training.warehouse.ports.model.ProductEvent;

public interface ProductsEventsPublisher {

    void publish(ProductEvent event);

}
