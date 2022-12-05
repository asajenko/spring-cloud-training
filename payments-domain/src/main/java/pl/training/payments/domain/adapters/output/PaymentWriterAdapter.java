package pl.training.payments.domain.adapters.output;

import lombok.RequiredArgsConstructor;
import pl.training.payments.domain.adapters.PaymentDomainMapper;
import pl.training.payments.domain.model.PaymentDomain;
import pl.training.payments.domain.servcie.PaymentDomainWriter;
import pl.training.payments.ports.output.PaymentWriter;

@RequiredArgsConstructor
public class PaymentWriterAdapter implements PaymentDomainWriter {

    private final PaymentWriter paymentWriter;
    private final PaymentDomainMapper mapper;

    @Override
    public PaymentDomain save(PaymentDomain paymentDomain) {
        var payment = mapper.toPorts(paymentDomain);
        return mapper.toDomain(paymentWriter.save(payment));
    }

}
