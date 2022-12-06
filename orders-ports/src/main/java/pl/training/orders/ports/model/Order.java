package pl.training.orders.ports.model;

import lombok.Value;

import java.util.List;

@Value
public class Order {

    Long id;
    List<OrderEntry> entries;

}
