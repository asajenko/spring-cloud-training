package pl.training.orders.adapters.output.payments;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import pl.training.orders.ports.model.Payment;
import pl.training.orders.ports.output.PaymentsService;

import javax.annotation.security.RolesAllowed;
import java.math.BigDecimal;
import java.util.Optional;

import static pl.training.commons.money.Currency.CURRENCY_SEPARATOR;

@Component
@RequiredArgsConstructor
public class FeignPaymentServiceAdapter implements PaymentsService {

    private final PaymentsApi paymentsApi;

    @RolesAllowed("ADMIN")
    @Secured("ADMIN")
    @PreAuthorize("")
    @PostAuthorize("")
    @Override
    public Optional<Payment> pay(BigDecimal value, String currency) {
       var paymentRequestDto = new PaymentRequestDto(1L, value + CURRENCY_SEPARATOR + currency);
       var paymentDto = paymentsApi.process(paymentRequestDto);
       return Optional.of(new Payment(paymentDto.getId(), paymentDto.getStatus()));
    }

}
