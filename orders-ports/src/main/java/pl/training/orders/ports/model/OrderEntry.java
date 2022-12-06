package pl.training.orders.ports.model;

import lombok.Value;

@Value
public class OrderEntry {

    Long productId;
    int quantity;

}
