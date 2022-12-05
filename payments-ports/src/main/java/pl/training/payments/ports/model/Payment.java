package pl.training.payments.ports.model;

import lombok.Value;
import pl.training.payments.ports.model.PaymentStatus;

import java.time.Instant;

@Value
public class Payment {

    String id;
    String value;
    Instant timestamp;
    PaymentStatus status;

}
