package pl.training.payments.domain.model;

import lombok.Builder;
import lombok.Value;
import org.javamoney.moneta.FastMoney;
import pl.training.payments.domain.model.PaymentStatusDomain;

import java.time.Instant;

@Builder
@Value
public class PaymentDomain {

    String id;
    FastMoney value;
    Instant timestamp;
    PaymentStatusDomain status;

}
