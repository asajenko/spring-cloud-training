package pl.training.payments.domain.adapters.input;

import lombok.RequiredArgsConstructor;
import pl.training.commons.aop.Atomic;
import pl.training.payments.domain.adapters.PaymentDomainMapper;
import pl.training.payments.domain.servcie.ProcessPaymentService;
import pl.training.payments.ports.input.ProcessPaymentUseCase;
import pl.training.payments.ports.model.Payment;
import pl.training.payments.ports.model.PaymentRequest;

@Atomic
@RequiredArgsConstructor
public class ProcessPaymentUseCaseAdapter implements ProcessPaymentUseCase {

    private final ProcessPaymentService processPaymentService;
    private final PaymentDomainMapper mapper;

    @Override
    public Payment process(PaymentRequest paymentRequest) {
        var paymentRequestDomain = mapper.toDomain(paymentRequest);
        var payment = processPaymentService.process(paymentRequestDomain);
        return mapper.toPorts(payment);
    }

}
