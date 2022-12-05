package pl.training.orders.ports.output;

import pl.training.orders.ports.model.Payment;

import java.math.BigDecimal;
import java.util.Optional;

public interface PaymentsService {

    Optional<Payment> pay(BigDecimal value, String currency);

}
