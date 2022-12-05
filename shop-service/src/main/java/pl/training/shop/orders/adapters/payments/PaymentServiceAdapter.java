package pl.training.shop.orders.adapters.payments;

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
    private final PaymentServiceMapper mapper;

    @Override
    public Optional<Payment> pay(BigDecimal value, String currency) {
        var paymentRequest = mapper.toDomain(value, currency);
        var payment = processPaymentUseCase.process(paymentRequest);
        return Optional.of(mapper.toDomain(payment));
    }

}
