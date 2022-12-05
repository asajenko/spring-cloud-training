package pl.training.shop.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.training.orders.ports.model.Payment;
import pl.training.orders.ports.output.PaymentsService;
import pl.training.payments.ports.input.ProcessPaymentUseCase;
import pl.training.payments.ports.model.PaymentRequest;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceAdapter implements PaymentsService {

    private final ProcessPaymentUseCase processPaymentUseCase;

    @Override
    public Optional<Payment> pay(BigDecimal value, String currency) {
        var paymentValue = "%s %s".formatted(value, currency);
        var paymentRequest = new PaymentRequest(1L, paymentValue);
        var payment = processPaymentUseCase.process(paymentRequest);
        return Optional.of(new Payment(payment.getId(), payment.getStatus().name()));
    }

}
