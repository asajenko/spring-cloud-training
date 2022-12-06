package pl.training.orders.adapters.output.payments;

import lombok.Data;

import java.time.Instant;

@Data
public class PaymentDto {

    private String id;
    private String value;
    private Instant timestamp;
    private String status;

}
