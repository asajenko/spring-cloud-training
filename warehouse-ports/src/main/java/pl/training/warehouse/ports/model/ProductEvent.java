package pl.training.warehouse.ports.model;

import lombok.Value;

import java.time.Instant;

@Value
public class ProductEvent {

    String description;
    Instant timestamp;

}
