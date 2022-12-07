package pl.training.warehouse.adapters.output.events;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;
import pl.training.warehouse.ports.model.ProductEvent;
import pl.training.warehouse.ports.output.ProductsEventsPublisher;

@Component
@RequiredArgsConstructor
public class AsyncProductsPublisherAdapter implements ProductsEventsPublisher {

    private static final String PRODUCTS_BINDING_NAME = "products-out-0";

    private final StreamBridge streamBridge;
    private final EventsProductMapper mapper;

    @Override
    public void publish(ProductEvent event) {
        var message = mapper.toMessage(event);
        streamBridge.send(PRODUCTS_BINDING_NAME, message);
    }

}
