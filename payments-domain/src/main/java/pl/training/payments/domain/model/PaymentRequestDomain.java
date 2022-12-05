package pl.training.payments.domain.model;

import lombok.Value;
import org.javamoney.moneta.FastMoney;

@Value
public class PaymentRequestDomain {

    Long id;
    FastMoney value;

}
