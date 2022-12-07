package pl.training.shop.warehouse;

import lombok.Data;
import lombok.Value;

import java.time.Instant;

@Data
public class ProductEventMessage {

    private String description;
    private Instant timestamp;

}
