package pl.training.orders.adapters.output.payments;

import lombok.Value;

@Value
public class PaymentRequestDto {

    Long requestId;
    String value;

}
