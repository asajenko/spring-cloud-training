package pl.training.orders.adapters.output.payments;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.training.orders.ports.model.Payment;
import pl.training.orders.ports.output.PaymentsService;

import java.math.BigDecimal;
import java.util.Optional;

import static pl.training.commons.money.Currency.CURRENCY_SEPARATOR;

@Component
@RequiredArgsConstructor
public class FeignPaymentServiceAdapter implements PaymentsService {

    private final PaymentsApi paymentsApi;

    @Override
    public Optional<Payment> pay(BigDecimal value, String currency) {
       var paymentRequestDto = new PaymentRequestDto(1L, value + CURRENCY_SEPARATOR + currency);
       var paymentDto = paymentsApi.process(paymentRequestDto);
       return Optional.of(new Payment(paymentDto.getId(), paymentDto.getStatus()));
    }

}
