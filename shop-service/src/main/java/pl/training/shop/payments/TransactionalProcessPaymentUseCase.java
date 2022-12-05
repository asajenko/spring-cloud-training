package pl.training.shop.payments;

import lombok.RequiredArgsConstructor;
import pl.training.payments.ports.model.Payment;
import pl.training.payments.ports.model.PaymentRequest;
import pl.training.payments.ports.input.ProcessPaymentUseCase;
import pl.training.shop.commons.aop.TransactionalProxy;

@TransactionalProxy
@RequiredArgsConstructor
public class TransactionalProcessPaymentUseCase implements ProcessPaymentUseCase {

    private final ProcessPaymentUseCase processPaymentUseCase;

    @Override
    public Payment process(PaymentRequest paymentRequest) {
        return processPaymentUseCase.process(paymentRequest);
    }

}
