package pl.training.payments.adapters.output.stream;

import org.mapstruct.Mapper;
import pl.training.payments.ports.model.Payment;

@Mapper(componentModel = "spring")
public interface StreamPaymentMapper {

    PaymentEvent toEvent(Payment payment);

}
