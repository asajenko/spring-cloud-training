package pl.training.warehouse.adapters.output.events;

import lombok.Value;

import java.time.Instant;

@Value
public class ProductEventMessage {

    String description;
    Instant timestamp;

}
