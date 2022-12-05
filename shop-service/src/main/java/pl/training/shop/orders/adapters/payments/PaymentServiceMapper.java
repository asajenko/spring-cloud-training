package pl.training.shop.orders.adapters.payments;

import org.mapstruct.Mapper;
import pl.training.orders.ports.model.Payment;
import pl.training.payments.ports.model.PaymentRequest;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface PaymentServiceMapper {

    default PaymentRequest toDomain(BigDecimal value, String currency) {
        var paymentValue = "%s %s".formatted(value, currency);
        return new PaymentRequest(1L, paymentValue);
    }

    Payment toDomain(pl.training.payments.ports.model.Payment payment);

}
