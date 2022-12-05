package pl.training.payments.domain.servcie;

import pl.training.payments.domain.servcie.PaymentIdGenerator;

import java.util.UUID;

class UuidPaymentIdGenerator implements PaymentIdGenerator {

    @Override
    public String getNext() {
        return UUID.randomUUID().toString();
    }

}
