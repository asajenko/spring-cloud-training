package pl.training.warehouse.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import pl.training.warehouse.ports.input.UpdateProductsPricesUseCase;
import pl.training.warehouse.ports.model.ProductEvent;
import pl.training.warehouse.ports.output.ProductsEventsPublisher;

import java.time.Instant;

@Log
@RequiredArgsConstructor
public class UpdateProductsPricesService implements UpdateProductsPricesUseCase {

    private static final String UPDATING_PRODUCTS_PRICES_MESSAGE = "Updating products prices...";

    private final ProductsEventsPublisher productsEventsPublisher;

    @Override
    public void update() {
        log.info(UPDATING_PRODUCTS_PRICES_MESSAGE);
        productsEventsPublisher.publish(new ProductEvent(UPDATING_PRODUCTS_PRICES_MESSAGE, Instant.now()));
    }

}
