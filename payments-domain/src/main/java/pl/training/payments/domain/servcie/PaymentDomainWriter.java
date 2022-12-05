package pl.training.payments.domain.servcie;

import pl.training.payments.domain.model.PaymentDomain;

public interface PaymentDomainWriter {

    PaymentDomain save(PaymentDomain paymentDomain);

}
